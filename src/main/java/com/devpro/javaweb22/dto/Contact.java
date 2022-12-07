/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 28, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.dto;

public class Contact {
	private String fullName;
	private String email;
	private String message;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
