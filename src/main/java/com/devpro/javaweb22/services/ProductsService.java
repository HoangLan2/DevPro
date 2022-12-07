/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 24, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.javaweb22.dto.Constants;
import com.devpro.javaweb22.dto.ProductSearch;
import com.devpro.javaweb22.model.ProductImages;
import com.devpro.javaweb22.model.Products;

@Service
public class ProductsService extends BaseService<Products> implements Constants{
	@Override
	protected Class<Products> clazz() {
		// TODO Auto-generated method stub
		return Products.class;
	}

	// tất cả các services cần thêm hàm search
	public List<Products> search(ProductSearch searchModel) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_products p WHERE 1=1";

		// tìm kiếm thao keyWord
		if (!StringUtils.isEmpty(searchModel.getKeyWord())) {
			sql += " and (p.title like '%" + searchModel.getKeyWord() + "%'"
					+ "or p.detail_description like '%"
					+ searchModel.getKeyWord() + "%'"
					+ " or p.short_description like '%"
					+ searchModel.getKeyWord() + "%')";
		}

		// chỉ lấy sp chưa xóa
		// sql += " and p.status=1 ";
		return executeNativeSql(sql, searchModel.getPage());
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

	@Transactional
	public Products save(Products product, MultipartFile productAvatar,
			MultipartFile[] productPictures)
			throws IllegalStateException, IOException {

		// kiểm tra có avatar đẩy lên k?
		if (!isEmptyUploadFile(productAvatar)) {
			String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/"
					+ productAvatar.getOriginalFilename();
			productAvatar.transferTo(new File(pathToFile));
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

}
