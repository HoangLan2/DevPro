/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

public class Employee {

	private Integer maNv;
	private String name;
	
	
	public Employee(Integer maNv, String name) {
		super();
		this.maNv = maNv;
		this.name = name;
	}
	public Integer getMaNv() {
		return maNv;
	}
	public void setMaNv(Integer maNv) {
		this.maNv = maNv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
