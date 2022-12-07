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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.services.ProductsService;

@Controller
public class ProductController {
	@Autowired
	ProductsService productsService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String product(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		// đẩy xuống view để xử lý
		model.addAttribute("products", productsService.findAll());

		return "customer/product";
	}

}
