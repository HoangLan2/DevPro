/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 18, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity {

	@Column(name = "username", length = 45, nullable = false)
	private String userName;

	@Column(name = "password", length = 100, nullable = false)
	private String passWord;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")

	private List<Roles> roles = new ArrayList<Roles>();

	public void addRoles(Roles role) {
		role.getUsers().add(this);
		roles.add(role);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
