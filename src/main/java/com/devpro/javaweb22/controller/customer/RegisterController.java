/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 21, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.model.Register;

@Controller
public class RegisterController {
	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		model.addAttribute("registerModel", new Register());
		return "customer/register";
	}

	// để hứng dữ liệu khi click submit button trong 1 spring form thì cần sử dụng {@ModeAttribute} và
	// giá trị phải giống với html attribute modelAttribute
	@RequestMapping(value = {
				"/register-spring-form" }, method = RequestMethod.POST)
	public String registerPost(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @ModelAttribute("registerModel") Register register)
			throws IOException {

		// final @ModelAttribute("registerModel") Register register)
		// lệnh trên đồng thời cũng đẩy contact xuống view với tên là contactModel
		// do vậy cần ghi đề phương thức ms
		model.addAttribute("message",
				"Cảm ơn " + register.getLastName() + " đã đăng ký.");
		model.addAttribute("registerModel", new Register());
		return "customer/register";
	}
}
