/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Cần định nghĩa đê spring - jpa biết
@Table(name = "tbl_category")
public class Categories extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	@Column(name = "seo", length = 100, nullable = false)
	private String seo;

	//  fetch = FetchType.LAZY : k lấy hết bên product
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Products> products = new HashSet<Products>();

	// theem 1 sp vao danh sach @OneTOMany
	public void addProduct(Products product) {
		products.add(product);
		product.setCategories(this);
	}

	// xoa san pham khoi danh sach @OneToMany
	public void deleteProduct(Products product) {
		products.remove(product);
		product.setCategories(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

}
