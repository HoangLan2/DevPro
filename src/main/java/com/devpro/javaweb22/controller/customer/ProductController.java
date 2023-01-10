/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.dto.ProductSearch;
import com.devpro.javaweb22.model.Products;
import com.devpro.javaweb22.services.BaseService;
import com.devpro.javaweb22.services.CategoriesService;
import com.devpro.javaweb22.services.PagerData;
import com.devpro.javaweb22.services.ProductService;

@Controller
public class ProductController extends BaseController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoriesService categoriesService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String product(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

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

		// đẩy xuống view để xử lý
		model.addAttribute("ps", ps);
		model.addAttribute("products", products);
		return "customer/product";
	}

	// đăng ký 1 request cho controller này
	@RequestMapping(value = {
				"/product/{categoryId}" }, method = RequestMethod.GET)
	public String product(final Model model, final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("categoryId") int categoryId) throws IOException {

		Integer currentPage = BaseService.NO_PAGING;

		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		// set các giá trị lấy đc vào ProductSearch dto
		ProductSearch ps = new ProductSearch();
		ps.setCategoryId(categoryId);
		ps.setCurrentPage(currentPage);
		PagerData<Products> products = productService.searchCategory(ps);
// đẩy xuống view để xử lý
		model.addAttribute("products", products);

		return "customer/product";
	}
}
