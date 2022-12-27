/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 7, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.Roles;
import com.devpro.javaweb22.model.User;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET) // -> action
	public String managerHome(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			if (((UserDetails) principal).getUsername().equals("Lan")) {
				return "redirect:/admin/home";
			} else {
				return "redirect:/home";
			}
		} else {
			return "login";
		}
	}
}
