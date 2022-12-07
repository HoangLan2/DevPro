/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.model.Contact;
import com.devpro.javaweb22.model.Employee;
import com.devpro.javaweb22.services.ContactService;

@Controller
public class ContactController extends BaseController {

	// cách sử dụng 1 spring-bean khác thì phải inject
	@Autowired
	private ContactService contactService;

	// đăng ký 1 request cho controller này
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String contact(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		// đẩy danh sách nhan viên xuống view
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(100, "Lan"));
		employees.add(new Employee(2, "Lan"));
		employees.add(new Employee(3, "Lan"));

		model.addAttribute("employees", employees);

		model.addAttribute("contactModel", new Contact());
		return "customer/contactus";
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
	public String contact_(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		// lấy dữ liệu từ view đẩy lên thông qua obj request
		String fullName = request.getParameter("lastname");
		System.out.println("Fullname " + fullName);

		// đẩy dữ liệu xuống view thông qua obj model
		model.addAttribute("message", "Cảm ơn bạn " + fullName + " đã liên hệ");

		return "customer/contactus";
	}

	// để hứng dữ liệu khi click submit button trong 1 spring form thì cần sử dụng {@ModeAttribute} và
	// giá trị phải giống với html attribute modelAttribute
	@RequestMapping(value = {
				"/contact-spring-from" }, method = RequestMethod.POST)
	public String contact_post_spring(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @ModelAttribute("contactModel") Contact contact)
			throws IOException {

		System.out.println(contact.getLastName() + contact.getEmail());
		contactService.saveOrUpdate(contact);
		return "customer/contactus";
	}

	// ajax trả về 1 responseEntity có data là 1 kiểu map
	@RequestMapping(value = { "/contact-ajax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_contact(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody Contact contact) {

		System.out.println(contact.getEmail());
		System.out.println(contact.getMessage());

		// trả về kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("statusCode", 200);
		jsonResult.put("statusMessage", "Cảm ơn bạn " + contact.getEmail()
				+ ", Chúng tôi sẽ liên hệ sớm");

		return ResponseEntity.ok(jsonResult);
	}
}
