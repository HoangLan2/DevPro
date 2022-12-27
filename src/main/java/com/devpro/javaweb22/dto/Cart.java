/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 24, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private BigDecimal totalPrice = BigDecimal.ZERO;
	private List<CartItem> cartItems = new ArrayList<CartItem>();

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
