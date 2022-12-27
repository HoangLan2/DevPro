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

import com.devpro.javaweb22.model.Products;
import com.devpro.javaweb22.services.ProductService;

@Controller
public class DetailProductController {

	@Autowired
	ProductService productsService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/detailProduct" }, method = RequestMethod.GET)
	public String detailProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/detail_product";
	}

	@RequestMapping(value = {
				"/detailProduct/{productId}" }, method = RequestMethod.GET)
	public String detailProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("productId") int productId) throws IOException {

		Products product = productsService.getById(productId);
		model.addAttribute("product", product);
		return "customer/detail_product";
	}
}
