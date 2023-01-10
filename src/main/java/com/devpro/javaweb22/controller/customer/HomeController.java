/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.dto.ProductSearch;
import com.devpro.javaweb22.model.Products;
import com.devpro.javaweb22.services.BaseService;
import com.devpro.javaweb22.services.PagerData;
import com.devpro.javaweb22.services.ProductService;

// @Controller: đánh dấu lớp này là Controller
@Controller
public class HomeController extends BaseController {

	// @Autowired: Inject Service vào để gọi được
	@Autowired
	private ProductService productService;

	// đăng ký 1 request cho controller này
	// hiện danh sách sản phẩm có phân trang
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET) // -> action
	public String listProduct(final Model model,
			final HttpServletRequest request,
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

		PagerData<Products> products = productService.newProduct(ps);

		// đẩy xuống view để xử lý
		model.addAttribute("ps", ps);
		model.addAttribute("products", products);

		model.addAttribute("productHot", productService.fildProductHot(ps));

		// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "customer/home"; // -> duong dan toi VIEW.
	}

}
