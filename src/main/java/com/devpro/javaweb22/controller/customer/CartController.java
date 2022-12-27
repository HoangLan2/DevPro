/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 17, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.controller.customer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.javaweb22.controller.BaseController;
import com.devpro.javaweb22.dto.Cart;
import com.devpro.javaweb22.dto.CartItem;
import com.devpro.javaweb22.model.Products;
import com.devpro.javaweb22.model.SaleOrder;
import com.devpro.javaweb22.model.SaleOrderProduct;
import com.devpro.javaweb22.services.ProductService;
import com.devpro.javaweb22.services.SaleOrderService;

@Controller
public class CartController extends BaseController {

	@Autowired
	ProductService productService;

	@Autowired
	SaleOrderService saleOrderService;

	// tổng giỏ hàng
	private BigDecimal getTotalPrice(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		Cart cart = null;
		if (httpSession.getAttribute("cart") != null) {
			cart = (Cart) httpSession.getAttribute("cart");
		} else {
			cart = new Cart();
			httpSession.setAttribute("cart", cart);
		}

		List<CartItem> cartItems = cart.getCartItems();
		BigDecimal total = BigDecimal.ZERO;

		for (CartItem item : cartItems) {
			total = total.add(BigDecimal.valueOf(item.getQuanlity())
					.multiply(item.getPriceUnit()));
		}
		cart.setTotalPrice(total);
		return total;
	}

	@RequestMapping(value = { "/cart/add" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody CartItem newItem) {

		// lấy đối tượng session
		// session tương tự như kiểu map và dc lưu trên memory
		HttpSession session = request.getSession();

		// lấy hông tin giỏ hàng

		Cart cart = null;

		// kiểm tra xem đã có giỏ hàng trên session
		if (session.getAttribute("cart") != null) {
			// nếu đã tồn tại giỏ hàng thì lấy ra từ session
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart(); // khởi tạo giỏ hàng mới
			session.setAttribute("cart", cart); // lưu giỏ hàng trên session
		}

		// lấy danh sách sản phẩm trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == newItem.getProductId()) {
				isExists = true;
				item.setQuanlity(item.getQuanlity() + newItem.getQuanlity());
			}
		}

		// kiểm tra không trong giỏ hàng thì lấy từ database
		if (!isExists) {
			Products productDb = productService.getById(newItem.getProductId());

			// thiết lập các giá trị khác liên quan
			newItem.setProductName(productDb.getTitle());
			newItem.setPriceUnit(productDb.getPriceSale());
			newItem.setAvatar(productDb.getAvatar());
			// add vào giỏ hàng
			cart.getCartItems().add(newItem);

		}
		for (CartItem item : cartItems) {
			if (item.getProductId() == newItem.getProductId()) {
				item.setTotalPriceItem(BigDecimal.valueOf(item.getQuanlity())
						.multiply(item.getPriceUnit()));
			}
		}

		getTotalPrice(request);
		// trả về kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));

		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}

	// tổng sản phẩm trong giỏ hàng
	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}
		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}
		return total;

	}

	@RequestMapping(value = { "/cart/view" }, method = RequestMethod.GET)
	public String cartView(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		if (!isLogined()) {

			model.addAttribute("message", "Cần đăng nhập để vào giỏ hàng");
			return "login";
		}
		return "customer/cart22";
	}

	@RequestMapping(value = { "/cart/finish" }, method = RequestMethod.POST)
	public String cartFinish(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		String customerName = request.getParameter("customerFullName");
		String customerEmail = request.getParameter("customerEmail");
		String customerPhone = request.getParameter("customerPhone");
		String customerAddress = request.getParameter("customerAddress");

		// tạo hóa đơn
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setCustomerName(customerName);
		saleOrder.setCustomerEmail(customerEmail);
		saleOrder.setCustomerPhone(customerPhone);
		saleOrder.setCustomerAddress(customerAddress);
		saleOrder.setCode(String.valueOf(System.currentTimeMillis()));
		// Kết hợp các sản phẩm trong giỏ hàng cho hóa đơn
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		for (CartItem cartItem : cart.getCartItems()) {
			SaleOrderProduct saleOrderProducts = new SaleOrderProduct();
			saleOrderProducts.setProduct(
					productService.getById(cartItem.getProductId()));
			saleOrderProducts.setQuality(cartItem.getQuanlity());
			saleOrder.addSaleOrderProduct(saleOrderProducts);
		}

		// lưu háo đơn
		saleOrderService.saveOrUpdate(saleOrder);

		// xóa dữ liệu giỏ hàng
		session.setAttribute("cart", null);
		return "customer/cart_success";
	}

	@RequestMapping(value = {
				"/ajax/updateQuanlityCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_UpdateQuanlityCart(
			final Model model, final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody CartItem cartItem) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		// kiểm tra xem session có tồn tại đối tượng nào tên là "cart"
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		int currentProductQuality = 1;
		BigDecimal totalPriceItem = BigDecimal.ZERO;
//		System.out.println(cartItem.getProductId());
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				currentProductQuality = item.getQuanlity()
						+ cartItem.getQuanlity();
				if (currentProductQuality < 0) {
					currentProductQuality = 0;
				}
				item.setQuanlity(currentProductQuality);

				totalPriceItem = item.getPriceUnit()
						.multiply(BigDecimal.valueOf(currentProductQuality));
			}
		}
		// trả về kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("currentProductQuality", currentProductQuality);
		jsonResult.put("totalPriceItem", totalPriceItem);
		jsonResult.put("totalCart", getTotalPrice(request));

		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}

}
