/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;
import java.util.List;

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
import com.devpro.javaweb22.services.ProductsService;

   	// @Controller: đánh dấu lớp này là Controller
@Controller
public class HomeController extends BaseController {

	// @Autowired: Inject Service vào để gọi được
	@Autowired
	private ProductsService productService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET) // -> action
	public String listProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		String keyWord = request.getParameter("keyword");
		ProductSearch ps = new ProductSearch();
		ps.setKeyWord(keyWord);
		ps.setPage(getCurrentPage(request));

		int pagePrev = ps.getPage();
		if (pagePrev <= 0) {
			pagePrev = 1;
		}
		List<Products> product = productService.search(ps);
		int pageNext = ps.getPage() + 2;
		if (product.size() <= 1) {
			pageNext = pageNext - 1;
		}

		model.addAttribute("pagePrev", pagePrev);
		model.addAttribute("pageNext", pageNext);

		//đẩy xuống view để xử lý
		model.addAttribute("products", productService.search(ps));
		//cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "customer/home"; // -> duong dan toi VIEW.
	}

}
