/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 23, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.Roles;
import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.UserService;

@Controller
public class AdminAccountController extends BaseController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	// hiện danh sách sản phẩm
	@RequestMapping(value = { "/admin/account" }, method = RequestMethod.GET) // -> action
	public String listProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		List<User> users = userService.findAllUser();

		model.addAttribute("users", users);

		// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "manager/admin_account"; // -> duong dan toi VIEW.
	}

	// hiện trang thêm user
	@RequestMapping(value = {
				"/admin/add-account" }, method = RequestMethod.GET) // -> action
	public String addProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		model.addAttribute("users", new User());
// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
		return "manager/add_account"; // -> duong dan toi VIEW.
	}

	// kích lưu người dùng
	@RequestMapping(value = { "/admin/add-user" }, method = RequestMethod.POST) // -> action
	public String addUser(final Model model, final HttpServletRequest request,
			final HttpServletResponse response,
			// hứng dữ liệu từ view đẩy lên
			@ModelAttribute("users") User user) throws Exception {

		// lấy thông tin từ view theo name
		String role = request.getParameter("role");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<User> users = userService.findAll();
		List<Roles> roles = roleService.findAll();
		boolean temp = true;
		for (User u : users) {

			boolean isPasswordMatch = passwordEncoder
					.matches(user.getPassword(), u.getPassword());

			if (((u.getUsername()).equals(user.getUsername()))
					&& isPasswordMatch) {
				temp = false;
			}
		}

		if (temp == true) {
			user.setPassWord(
					new BCryptPasswordEncoder(4).encode(user.getPassWord()));
			userService.saveOrUpdate(user);

			User userDB = userService.getById(user.getId());

			for (Roles r : roles) {
				if (r.getName().equals(role)) {
					userDB.addRoles(roleService.getById(r.getId()));
				}
			}
			userService.saveOrUpdate(userDB);

			model.addAttribute("message", "thành công!");
			// trở về trang danh sách user
			return "redirect:/admin/account"; // -> duong dan toi VIEW.
		} else {
			model.addAttribute("notifi", "Tài khoản đã tồn tại, mời nhập lại ");
			// trở về trang danh sách user
			return "/admin/add-account"; // -> duong dan toi VIEW.
		}
	}
}
