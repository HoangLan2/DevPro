/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 18, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity implements UserDetails {

	@Pattern(regexp = "[a-zA-Z][a-zA-Zếềệễòóọõéèẽẹaáàãạăắằặẵấậâầẫôốồỗộơỡờớợiíìĩị ]+", message = "Tên không được chứa kí tự đặc biệt")
	@NotEmpty(message = "Tên không được để trống")
	@Column(name = "username", length = 45, nullable = false)
	private String userName;

	@NotEmpty(message = "Mật khẩu không được để trống")
	@Pattern(regexp = "((?=.*[@!#$%^&*?])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,100})", message = "Mật khẩu ít nhất 8 kí tự, có chữ hoa, số và có ký tự đặc biệt")
	@Column(name = "password", length = 100, nullable = false)
	private String passWord;

	@NotEmpty(message = "Mail không được để trống")
	@Email(message = "Email không hợp lệ định dạng đúng 'abc@gmail.com'")
	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@NotEmpty(message = "Số điện thoại không được để trống")
	@Pattern(regexp = "[0-9]+", message = "Số điện thoại không hợp lệ")
	@Length(min = 10, max = 10, message = "Số điện thoại phải có 10 số!")
	@Column(name = "phone", length = 100, nullable = true)
	private String phone;

	@NotEmpty(message = "Địa chỉ không được để trống")
	@Column(name = "shipping_address", length = 1000, nullable = true)
	private String shippingAddress;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	// danh sách role của user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passWord;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
