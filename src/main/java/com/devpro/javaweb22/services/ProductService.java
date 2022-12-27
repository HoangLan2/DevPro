/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 24, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import java.io.File;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.javaweb22.dto.Constants;
import com.devpro.javaweb22.dto.ProductSearch;
import com.devpro.javaweb22.model.ProductImages;
import com.devpro.javaweb22.model.Products;

@Service
public class ProductService extends BaseService<Products> implements Constants {
	@Autowired
	ProductImageService productImageService;

	@Override
	protected Class<Products> clazz() {
		// TODO Auto-generated method stub
		return Products.class;
	}

	@PersistenceContext
	protected EntityManager entityManager;

	public PagerData<Products> searchProduct(ProductSearch productSearch) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_products p WHERE 1=1";

		if (productSearch != null) {

			// tìm kiếm theo category
			if (productSearch.getCategoryId() != null
					&& productSearch.getCategoryId() > 0) {
				sql += " and category_id = " + productSearch.getCategoryId();
			}

			// tìm kiếm theo title và description
			if (!StringUtils.isEmpty(productSearch.getKeyWord())) {
				sql += " and (p.title like '%" + productSearch.getKeyWord()
						+ "%'" + " or p.detail_description like '%"
						+ productSearch.getKeyWord() + "%'"
						+ " or p.short_description like '%"
						+ productSearch.getKeyWord() + "%')";
			}
		}
		// chỉ lấy sp chưa xóa
		sql += " and p.status=1 order by p.id desc";
		return super.getEntitiesByNativeSQL(sql,
				productSearch.getCurrentPage());
	}

	private boolean isEmptyUploadFile(MultipartFile[] images) {
		if (images == null || images.length <= 0)
			return true;
		if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
			return true;
		return false;
	}

	private boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}

	@Transactional // đảm bảo tất cả thành công hoặc tất cả thất bại
	public Products save(Products product, MultipartFile productAvatar,
			MultipartFile[] productPictures)
			throws IllegalStateException, IOException {

		// kiểm tra có avatar đẩy lên k?
		if (!isEmptyUploadFile(productAvatar)) {
			// tạo đường dẫn tới folder
			String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/"
					+ productAvatar.getOriginalFilename();

			// lưu avatar vào đường dãn trên
			productAvatar.transferTo(new File(pathToFile));

			// lưu avatar và databasse
			product.setAvatar(
					"product/avatar/" + productAvatar.getOriginalFilename());
		}

		// kiểm tra có productimage đẩy lên k?
		if (!isEmptyUploadFile(productPictures)) {
			for (MultipartFile pic : productPictures) {

				pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures/"
						+ pic.getOriginalFilename()));
				ProductImages pi = new ProductImages();
				pi.setPath("product/pictures/" + pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());
				product.addProductImages(pi);
			}
		}
		// save to db
		return super.saveOrUpdate(product);
	}

	@Transactional
	public Products edit(Products product, MultipartFile productAvatar,
			MultipartFile[] productPictures) throws Exception {

		// lay thong tin san pham trong db.
		Products productOnDb = super.getById(product.getId());

		// có đẩy avartar ???
		if (!isEmptyUploadFile(productAvatar)) {
			// xóa avatar trong folder lên
			new File(UPLOAD_FOLDER_ROOT + productOnDb.getAvatar()).delete();

			// add avartar moi
			productAvatar.transferTo(new File(UPLOAD_FOLDER_ROOT
					+ "product/avatar/" + productAvatar.getOriginalFilename()));
			product.setAvatar(
					"product/avatar/" + productAvatar.getOriginalFilename());
		} else {
			// su dung lai avatar cu
			product.setAvatar(productOnDb.getAvatar());
		}

		// có đẩy pictures ???
		if (!isEmptyUploadFile(productPictures)) {

			// xóa picture cũ đi
			if (productOnDb.getProductImages() != null
					&& productOnDb.getProductImages().size() > 0) {
				for (ProductImages opi : productOnDb.getProductImages()) {
					// xóa avatar trong folder
					new File(UPLOAD_FOLDER_ROOT + opi.getPath()).delete();

					// xóa dữ liệu của image cho sản phẩm đang sửa ở database
					productImageService.delete(opi);
				}
			}

			for (MultipartFile pic : productPictures) {
				pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures/"
						+ pic.getOriginalFilename()));

				ProductImages pi = new ProductImages();
				pi.setPath("product/pictures/" + pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());

				product.addProductImages(pi);
			}
		}

		// lưu vào database
		return super.saveOrUpdate(product);
	}

	@Transactional
	public PagerData<Products> fildProductHot(ProductSearch productSearch) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_products p WHERE p.is_hot = 1 and status = '1'";
		return super.getEntitiesByNativeSQL(sql,
				productSearch.getCurrentPage());
	}

	public PagerData<Products> searchCategory(ProductSearch productSearch) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_products p WHERE 1=1";

		// tìm kiếm thao keyWord
		if (!StringUtils.isEmpty(productSearch.getCategoryId())) {
			sql += " and p.category_id = " + productSearch.getCategoryId();
		}

		// chỉ lấy sp chưa xóa
		sql += " and p.status=1 ";
		return super.getEntitiesByNativeSQL(sql,
				productSearch.getCurrentPage());
	}

	@Transactional
	public PagerData<Products> newProduct(ProductSearch productSearch) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_products where status = '1' order by created_date desc";

		return super.getEntitiesByNativeSQL(sql,
				productSearch.getCurrentPage());
	}

}

//-------------
//@Transactional
//public Product saveProduct(Product product, MultipartFile productAvatar, MultipartFile[] productPictures)
//		throws IllegalStateException, IOException {
//
//	// kiểm tra xem admin có đẩy avatar lên không ???
//	if (!isEmptyUploadFile(productAvatar)) { // có đẩy avatar lên.
//
//		String fileName = getUniqueUploadFileName(productAvatar.getOriginalFilename());
//
//		// tạo đường dẫn tới folder chứa avatar
//		String pathToAvatar = "C:/upload/product/avatar/" + fileName;
//
//		// lưu avatar vào đường dẫn trên
//		productAvatar.transferTo(new File(pathToAvatar));
//
//		product.setAvatar("product/avatar/" + fileName);
//	}
//
//	// có đẩy pictures(product_images) ???
//	if (!isEmptyUploadFile(productPictures)) { // có đẩy pictures lên.
//
//		// nếu admin đẩy lên thì duyệt tất cả file đẩy lên và lưu trên server
//		for (MultipartFile pic : productPictures) {
//			String fileName = getUniqueUploadFileName(pic.getOriginalFilename());
//
//			// lưu ảnh admin đẩy lên vào server
//			pic.transferTo(new File("C:/upload/product/pictures/" + fileName));
//
//			// tạo mới 1 bản ghi product_images
//			ProductImages productImages = new ProductImages();
//			productImages.setPath("product/pictures/" + fileName);
//			productImages.setTitle(fileName);
//
//			product.addProductImages(productImages);
//		}
//	}
//
//	// tạo seo: bổ sung thêm thời gian tính bằng miliseconds để tránh trùng seo
////			p.setSeo(new Slugify().slugify(p.getTitle() + "-" + System.currentTimeMillis()));
//
//	// lưu vào database
//	return super.saveOrUpdate(product);
//
//}

//-------------------------------Thầy-------------------------

//
//@RequestMapping(value = { "/admin/product/management" }, method = RequestMethod.POST)
//	public String adminProductAddOrUpdate(final Model model, 
//										  final HttpServletRequest request,
//										  final HttpServletResponse response, 
//										  @ModelAttribute("product") Product product, //spring-form binding
//										  @RequestParam("productAvatar") MultipartFile productAvatar,
//										  @RequestParam("productPictures") MultipartFile[] productPictures) throws Exception {
//		// kiểm tra xem thông tin product đẩy lên khi click submit nên là tạo mới hay chỉnh sửa
//		if(product.getId() != null && product.getId() > 0) { //chỉnh sửa sản phẩm
//			productService.updateProduct(product, productAvatar, productPictures);
//		} else { //thêm mới
//			productService.saveProduct(product, productAvatar, productPictures);	
//		}
//		
//		// trở về trang danh sách sản phẩm
//		return "redirect:/admin/product/list";
//	}
//
//--------------------------
//
//@Transactional
//	public Product updateProduct(Product p, MultipartFile productAvatar, MultipartFile[] productPictures)
//			throws IllegalStateException, IOException {
//
//		// lấy thông tin cũ của product theo id đang có trong database
//		Product productInDb = super.getById(p.getId());
//
//		// có đẩy avartar ??? => xóa avatar cũ đi và thêm avatar mới
//		if (!isEmptyUploadFile(productAvatar)) {
//			// xóa avatar cũ trong folder
//			new File("C:/upload/" + productInDb.getAvatar()).delete();
//
//			// update avatar mới
//			String fileName = getUniqueUploadFileName(productAvatar.getOriginalFilename());
//			productAvatar.transferTo(new File("C:/upload/product/avatar/" + fileName));
//			p.setAvatar("product/avatar/" + fileName);
//		} else {
//			// sử dụng lại avartar cũ
//			p.setAvatar(productInDb.getAvatar());
//		}
//
//		// có đẩy pictures ???
//		if (!isEmptyUploadFile(productPictures)) {
//
//			// xóa pictures cũ
//			if (productInDb.getProductImages() != null && productInDb.getProductImages().size() > 0) {
//				for (ProductImages opi : productInDb.getProductImages()) {
//					// xóa avatar trong folder lên
//					new File("C:/upload/" + opi.getPath()).delete();
//
//					// xóa dữ liệu của image cho sản phẩm đang sửa trong database
//					productImagesService.delete(opi);
//				}
//			}
//
//			// update pictures mới
//			for (MultipartFile pic : productPictures) {
//				String fileName = getUniqueUploadFileName(pic.getOriginalFilename());
//				
//				pic.transferTo(new File("C:/upload/product/pictures/" + fileName));
//				
//				ProductImages pi = new ProductImages();
//				pi.setPath("product/pictures/" + fileName);
//				pi.setTitle(fileName);
//				
//				p.addProductImages(pi);
//			}
//		}
//
//		//tạo seo
////		p.setSeo(new Slugify().slugify(p.getTitle() + "-" + System.currentTimeMillis()));
//		
//		// lưu vào database
//		return super.saveOrUpdate(p);
//	}