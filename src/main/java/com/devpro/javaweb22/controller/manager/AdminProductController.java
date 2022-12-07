/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 28, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.dto.Product;
import com.devpro.javaweb22.model.Products;

@Controller
public class AdminProductController {
	@RequestMapping(value = {
				"/admin/product/add" }, method = RequestMethod.GET)
	public String addProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		model.addAttribute("addProductModel", new Product());
		return "manager/add_product";
	}

	@RequestMapping(value = {
				"/admin/product/list" }, method = RequestMethod.GET)
	public String listProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		return "manager/list_product";
	}

	// để hứng dữ liệu khi click submit button trong 1 spring form thì cần sử dụng {@ModeAttribute} và
	// giá trị phải giống với html attribute modelAttribute
	@RequestMapping(value = {
				"/admin/add-product-spring-from" }, method = RequestMethod.POST)
	public String contact_post_spring(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @ModelAttribute("addProductModel") Product product)
			throws IOException {
		System.out.println(String.format("[%-20s, %-10s]", "Mã sản phẩm",
				product.getId())

				+ "\n"
				+ String.format("[%-20s, %-10s]", "Mã danh mục",
						product.getCategoryId())
				+ "\n"
				+ String.format(
						"[%-20s, %-10s]", "Tên sản phẩm", product.getTitle())
				+ "\n"
				+ String.format("[%-20s, %-10s]", "Giá nhập",
						product.getPrice())
				+ "\n"
				+ String.format(
						"[%-20s, %-10s]", "Giá bán", product.getPriceSale())
				+ "\n"
				+ String.format(
						"[%-20s, %-10s]", "Mô tả ngắn", product.getShortDes())
				+ "\n"
				+ String.format("[%-20s, %-10s]", "Mô tả chi tiết",
						product.getDetails())
				+ "\n"
				+ String.format("[%-20s, %-10s]", "Link ảnh",
						product.getAvatar())
				+ "\n" + String.format("[%-20s, %-10s]", "Ngày tạo",
						product.getCreatedDate()));

		/*
		 * System.out.println("Mã sản phẩm: " + product.getId() + "\nMã danh mục: " +
		 * product.getCategoryId() + "\nTên sản phẩm: " + product.getTitle() + "\nGiá nhập: " +
		 * product.getPrice() + "\nGiá bán: " + product.getPriceSale() + "\n Mô tả ngắn: " +
		 * product.getShortDes() + "\nMô tả chi tiết: " + product.getDetails() + "\n Link ảnh: " +
		 * product.getAvatar() + "\n Ngày tạo: " + product.getCreatedDate());
		 */
		return "manager/add_product";
	}
}
