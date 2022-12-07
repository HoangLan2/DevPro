/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 29, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCategoryController {
	@RequestMapping(value = { "/admin/catrgiores" }, method = RequestMethod.GET)
	public String listCategories(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		return "manager/categories";
	}
}
