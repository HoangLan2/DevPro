/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 24, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.dto;

import java.math.BigDecimal;

public class CartItem {

	private int productId;
	private String productName;
	private int quanlity;
	private BigDecimal priceUnit;
	private String avatar;
	private BigDecimal totalPriceItem;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public BigDecimal getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(BigDecimal priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getTotalPriceItem() {
		return totalPriceItem;
	}

	public void setTotalPriceItem(BigDecimal totalPriceItem) {
		this.totalPriceItem = totalPriceItem;
	}

}
