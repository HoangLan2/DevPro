/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 21, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.model.User;
import com.devpro.javaweb22.services.RegisterService;
import com.devpro.javaweb22.services.RoleService;
import com.devpro.javaweb22.services.UserService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		model.addAttribute("registerModel", new User());
		return "customer/register";
	}

	// để hứng dữ liệu khi click submit button trong 1 spring form thì cần sử dụng {@ModeAttribute} và
	// giá trị phải giống với html attribute modelAttribute
	@RequestMapping(value = {
				"/register-spring-form" }, method = RequestMethod.POST)
	public String registerPost(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final  @Validated @ModelAttribute("registerModel") User user,
			BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "customer/register";
		}
		// lệnh trên đồng thời cũng đẩy contact xuống view với tên là contactModel
		// do vậy cần ghi đề phương thức ms

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<User> users = userService.findAll();
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

			registerService.saveOrUpdate(user);

			User userDB = userService.getById(user.getId());
			userDB.addRoles(roleService.getById(17));

			registerService.saveOrUpdate(userDB);

			model.addAttribute("message",
					"Cảm ơn " + user.getUsername() + " đã đăng ký.");
			model.addAttribute("registerModel", new User());
		}

		else {
			model.addAttribute("notifi", "Tài khoản đã tồn tại, mời nhập lại ");
		}

		return "customer/register";
	}
}
