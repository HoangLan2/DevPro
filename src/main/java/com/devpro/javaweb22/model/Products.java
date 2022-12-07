/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Cần định nghĩa đê spring - jpa biết
@Table(name = "tbl_products")
public class Products extends BaseEntity {
	@Column(name = "title", length = 1000, nullable = false)
	private String title;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "price_sale")
	private BigDecimal priceSale;

	@Column(name = "short_description", length = 3000, nullable = false)
	private String shortDes;

	@Lob
	@Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT")
	private String details;

	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;

	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;

	@Column(name = "is_hot", nullable = true)
	private Boolean isHot = Boolean.FALSE;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Categories categories;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "products")
	private Set<ProductImages> productImages = new HashSet<ProductImages>();

	// theem 1 sp vao danh sach @OneTOMany
	public void addProductImages(ProductImages productImage) {
		productImages.add(productImage);
		productImage.setProducts(this);
	}

	// xoa san pham khoi danh sach @OneToMany
	public void deleteProductImages(ProductImages productImage) {
		productImages.remove(productImage);
		productImage.setProducts(null);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Set<ProductImages> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImages> productImages) {
		this.productImages = productImages;
	}

}
