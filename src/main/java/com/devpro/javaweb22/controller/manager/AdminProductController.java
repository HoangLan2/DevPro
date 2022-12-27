/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 28, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.dto.ProductSearch;
import com.devpro.javaweb22.model.Categories;
import com.devpro.javaweb22.model.Products;
import com.devpro.javaweb22.services.BaseService;
import com.devpro.javaweb22.services.CategoriesService;
import com.devpro.javaweb22.services.PagerData;
import com.devpro.javaweb22.services.ProductService;

@Controller
public class AdminProductController extends BaseController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoriesService categoriesService;

	@RequestMapping(value = {
				"/admin/add-products" }, method = RequestMethod.GET) // -> action
	public String addProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		model.addAttribute("product", new Products());
		// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "manager/add_product"; // -> duong dan toi VIEW.
	}

	@RequestMapping(value = {
				"/admin/add-products" }, method = RequestMethod.POST) // -> action
	public String addProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			// hứng dữ liệu từ view đẩy lên
			@ModelAttribute("product") Products product,
			// vì spring from k input dạng file có nên phải hứng bằng requestParam. map bằng name
			@RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures)
			throws Exception {

		// kiểm tra xem action là thêm mới hay chỉnh sửa
		if (product.getId() == null || product.getId() <= 0) {
			productService.save(product, productAvatar, productPictures);
			model.addAttribute("message", "Lưu thành công!");

		} else {
			productService.edit(product, productAvatar, productPictures);
			model.addAttribute("message", "Sửa thành công!");
		}

		// trở về trang danh sách sản phẩm
		return "redirect:/admin/product/list"; // -> duong dan toi VIEW.
	}

	// hiện danh sách sản phẩm
	@RequestMapping(value = {
				"/admin/product/list" }, method = RequestMethod.GET) // -> action
	public String listProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		// đẩy xuống view để xử lý

		// lấy thông tin từ request param
		String keyWord = request.getParameter("keyword");
		Integer categoryId = 0;
		try {
			categoryId = Integer.parseInt(request.getParameter("categoryId"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		Integer currentPage = BaseService.NO_PAGING;

		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		// set các giá trị lấy đc vào ProductSearch dto
		ProductSearch ps = new ProductSearch();
		ps.setKeyWord(keyWord);
		ps.setCategoryId(categoryId);
		ps.setCurrentPage(currentPage);

		PagerData<Products> products = productService.searchProduct(ps);

		model.addAttribute("ps", ps);
		model.addAttribute("products", products);
		// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "manager/list_product"; // -> duong dan toi VIEW.
	}

//	// để hứng dữ liệu khi click submit button trong 1 spring form thì cần sử dụng {@ModeAttribute} và
//	// giá trị phải giống với html attribute modelAttribute
//	@RequestMapping(value = {
//				"/admin/add-product-spring-from" }, method = RequestMethod.POST)
//	public String contact_post_spring(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response,
//			@ModelAttribute("product") Products product,
//			@RequestParam("productAvatar") MultipartFile productAvatar,
//			@RequestParam("productPictures") MultipartFile[] productPictures)
//			throws Exception {
//
//		// kiểm tra xem action là thêm mới hay chỉnh sửa
//		if (product.getId() == null || product.getId() <= 0) {
//			productService.save(product, productAvatar, productPictures);
//		} else {
//			productService.edit(product, productAvatar, productPictures);
//		}
//		return "manager/add_product";
//	}

	@RequestMapping(value = {
				"/admin/del-product/{productId}" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_contact(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody Products product) {
		System.out.println(product.getId());
		Products p = productService.getById(product.getId());
		p.setStatus(false);
		productService.saveOrUpdate(p);
		// trả về kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("statusCode", 200);
		jsonResult.put("statusMessage",
				"Bạn có muốn xóa " + product.getId() + " không?");

		return ResponseEntity.ok(jsonResult);
	}

	// edit
	// /admin/product/144 <-> Path Variable
	// /admin/product?productId=144
	@RequestMapping(value = {
				"/admin/edit-products/{productId}" }, method = RequestMethod.GET) // -> action
	public String editProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("productId") int productId) throws IOException {

		// lấy sản phẩm từ database
		Products product = productService.getById(productId);

		// can lay danh sach categories tu db va tra ve view qua model
		List<Categories> categories = categoriesService.findAllActive();

		model.addAttribute("product", product);

		// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "manager/add_product"; // -> duong dan toi VIEW.
	}

}

// phân trang 
//String keyWord = request.getParameter("keyword");
//ProductSearch ps = new ProductSearch();
//ps.setKeyWord(keyWord);
//ps.setPage(getCurrentPage(request));
//
//int pagePrev = ps.getPage();
//if (pagePrev <= 0) {
//	pagePrev = 1;
//}
//List<Products> product = productService.search(ps);
//int pageNext = ps.getPage() + 2;
//if (product.size() <= 1) {
//	pageNext = pageNext - 1;
//}
//
//model.addAttribute("pagePrev", pagePrev);
//model.addAttribute("pageNext", pageNext);
