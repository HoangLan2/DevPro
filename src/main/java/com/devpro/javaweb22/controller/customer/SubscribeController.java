/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 28, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.dto.Subscribe;

@Controller
public class SubscribeController {
	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/subscribe" }, method = RequestMethod.GET)
	public String product(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		return "customer/subscribe";
	}

	// ajax trả về 1 responseEntity có data là 1 kiểu map

	@RequestMapping(value = { "/subscribe-ajax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_contact(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody Subscribe subscribe) {

		System.out.println(subscribe.getEmail());

		// trả về kết quả Map<String, Object> jsonResult = new HashMap<String, Object>();
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("statusCode", 200);
		jsonResult.put("statusMessage", "Cảm ơn bạn " + subscribe.getEmail()
				+ ", Chúng tôi sẽ liên hệ sớm");

		return ResponseEntity.ok(jsonResult);
	}

}
