/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.devpro.javaweb22.model.Categories;
import com.devpro.javaweb22.model.Roles;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.CategoriesService;
import com.devpro.javaweb22.services.RoleService;

public abstract class BaseController {

	@Autowired
	CategoriesService categoriesService;

	@Autowired
	RoleService roleService;

	public int getCurrentPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page")) - 1;
		} catch (Exception e) {
			return -1;
		}
	}

//			Kiểm tra xem người dùng đã đăng nhập chưa?
//			User logined có thể truy cập thông qua class SecurityContextHolder
//			@return true|false , true nếu login ngược lại false

	@ModelAttribute("isLogined")
	public boolean isLogined() {
		boolean isLogined = false;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			isLogined = true;
		}
		return isLogined;
	}

//	trả về etity User chính là user logined
//	User logined có thể truy cập thông tin qua class SecurityContextHolder
//	@return
	@ModelAttribute("userLogined")
	public User getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (userLogined != null && userLogined instanceof UserDetails) {
			return (User) userLogined;
		}
		return new User();
	}

	@ModelAttribute("categories")
	public List<Categories> getAllCategories() {
		return categoriesService.findAll();
	}

	@ModelAttribute("role")
	public List<Roles> getAllRoles() {
		return roleService.findAll();
	}
}
