/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public String home(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/cart22";
	}

}
