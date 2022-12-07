/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 18, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder_products")
public class SaleOrderProduct extends BaseEntity {
	@Column(name = "product_id", nullable = false)
	private Integer productId;

	@Column(name = "quality", nullable = false)
	private Integer quality;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "saleorder_id")
	private SaleOrder saleOrder;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	
}
