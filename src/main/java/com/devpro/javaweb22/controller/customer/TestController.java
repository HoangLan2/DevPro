/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
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

import com.devpro.javaweb22.controller.BaseController;

// 1. Báo cho spring mvc biết đây là 1 controller
// 2. Tạo ra 1 bean và đc quản lý bởi spring-controller
@Controller
public class TestController extends BaseController {

// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test(final Model model, 
					   final HttpServletRequest request, 
					   final HttpServletResponse response)
			throws IOException {
		return "customer/test";
	}
}
