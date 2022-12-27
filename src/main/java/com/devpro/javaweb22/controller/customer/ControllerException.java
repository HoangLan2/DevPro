/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 19, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler({ Exception.class }) // Có thể bắt nhiều loại exception
	public String handleExceptionA(Exception e) {
		return "customer/test";
	}
}
