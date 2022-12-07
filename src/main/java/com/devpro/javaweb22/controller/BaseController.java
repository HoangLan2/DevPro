/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

	public int getCurrentPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"))-1;
		} catch (Exception e) {
			return -1;
		}
	}
}
