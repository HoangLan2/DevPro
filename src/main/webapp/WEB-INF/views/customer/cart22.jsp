<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Giỏ hàng</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header2.jsp"></jsp:include>


	<main>
		<div class="breadcrumb">
			<ol>
				<li style="margin-right: 10px;"><img src="${base}/img/nha.png"></li>
				<li><a href="">Trang chủ</a></li>
				<li>Giỏ hàng</li>
			</ol>
		</div>

		<div class="container">
			<div class="main">
				<div class="sub">

					<table class="table" style="margin-left: 20px; margin-right: 200px">
						<thead class="thead-light">
							<tr>
								<th>Hình ảnh</th>
								<th scope="col">Sản phẩm</th>
								<th scope="col">Giá</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Tạm tính</th>
							</tr>
						</thead>
						<c:forEach items="${cart.cartItems }" var="cartItem">
							<tbody>
								<tr>
									<td><img src="${base }/upload/${cartItem.avatar }"
										style="width: 150px; height: 150px"></td>
									<td>${cartItem.productName }</td>
									<td>${cartItem.priceUnit }</td>
									<td><button
											onclick="UpdateQuanlityCart('${base }', ${cartItem.productId}, -1)"
											value="-">-</button> <strong><span
											id="quanlity_${cartItem.productId}">${cartItem.quanlity }</span></strong>
										<button
											onclick="UpdateQuanlityCart('${base }', ${cartItem.productId}, 1)"
											value="+">+</button></td>
									<td><span id="totalPriceItem${cartItem.productId}">
											${cartItem.totalPriceItem } </span> VNĐ</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<%-- 
					<div class="content">
						<div class="name_pro">Sản phẩm</div>
						<div class="price_pro">Giá</div>
						<div class="amount_pro">Số lượng</div>
						<div class="totle_pro">Tạm tính</div>
					</div>
					<hr>

					<!-- hiển thị danh sách sản phẩm trong giỏ hàng -->
					<c:forEach items="${cart.cartItems }" var="cartItem">
						<div class="content_2">
							<div>
								<img src="${base }/upload/${cartItem.avatar }"
									style="width: 150px; height: 120px">
							</div>
							<div class="name_pro_detail">${cartItem.productName }</div>
							<div class="price_pro_detail">${cartItem.priceUnit }</div>
							<div class="amount_pro_detail">
								<button
									onclick="UpdateQuanlityCart('${base }', ${cartItem.productId}, -1)"
									value="-">-</button>
								<strong><span id="quanlity_${cartItem.productId}">${cartItem.quanlity }</span></strong>
								<button
									onclick="UpdateQuanlityCart('${base }', ${cartItem.productId}, 1)"
									value="+">+</button>

							</div>
							<div class="totle_pro_detail">
								<span id="totalPriceItem${cartItem.productId}">
									${cartItem.totalPriceItem } </span> VNĐ
							</div>

						</div>
					</c:forEach>
					<hr>--%>
				</div>

				<div class="summary" style="margin-left: 40px">
					<div style="font-size: 18px; color: #666666; font-weight: bold;">Cộng
						giỏ hàng</div>
					<hr>
					<div class="provisional">
						<div style="margin-right: 180px;">Phí Ship</div>
						<div style="font-weight: bold;">
							<span> Free</span>
						</div>
					</div>
					<hr>
					<div class="provisional">
						<div style="margin-right: 140px; font-weight: bold;">Tổng</div>
						<div style="font-weight: bold; color: #cc9933;">
							<span id="totalCart"> ${cart.totalPrice } </span> VNĐ
						</div>
					</div>
				</div>
			</div>
			<div>
				<!-- form cho việc thanh toán -->
				<form action="${base }/cart/finish" method="post">

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông
								tin khách hàng</div>
							<div class="p-4">
								<div class="form-group" style="margin-bottom: 5px;">
									<label for="customerPhone">Họ và tên khách hàng</label> <input
										type="text" class="form-control" id="customerFullName"
										name="customerFullName" value="${userLogined.userName }"
										placeholder="Full name">
								</div>
								<div class="form-group" style="margin-bottom: 5px;">
									<label for="customerEmail">Địa chỉ Email</label> <input
										type="email" class="form-control" id="customerEmail"
										name="customerEmail" value="${userLogined.email }"
										placeholder="Enter email">
								</div>
								<div class="form-group" style="margin-bottom: 5px;">
									<label for="customerPhone">Phone</label> <input type="tel"
										class="form-control" id="customerPhone" name="customerPhone"
										value="${userLogined.phone }" placeholder="Phone">
								</div>
								<div class="form-group" style="margin-bottom: 5px;">
									<label for="customerAddress">Địa chỉ giao hàng</label> <input
										type="text" class="form-control" id="customerAddress"
										name="customerAddress" value="${userLogined.shippingAddress }"
										placeholder="Address">
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông
								tin thanh toán</div>
							<div class="p-4">

								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng đơn hàng </strong><strong><span
											id="totalCart3">${cart.totalPrice } </span> VNĐ</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí ship</strong><strong>Free</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Thuế</strong><strong>Free</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng</strong>
										<h5 class="font-weight-bold totalPrice">
											<span id="totalCart2"> ${cart.totalPrice } </span> VNĐ
										</h5></li>
								</ul>

								<button type="submit" class="btn-submit">Tiến hành
									thanh toán</button>

							</div>
						</div>
					</div>

				</form>

			</div>
		</div>

	</main>
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>

	<script type="text/javascript">
	
	function UpdateQuanlityCart(baseUrl, productId, quanlity) {
		
		// javascript object.  data la du lieu ma day len action cua controller
		let data = {
			productId: productId, // lay theo id	
			quanlity: quanlity
		};
		
		// $ === jQuery
		// json == javascript object
		jQuery.ajax({
			url: baseUrl + "/ajax/updateQuanlityCart", //->action
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json", // kieu du lieu tra ve tu controller la json
			success: function(jsonResult) {
				// tăng số lượng sản phẩm trong giỏ hàng trong icon
				$( "#quanlity_" + productId ).html(jsonResult.currentProductQuality);
				// tổng giỏ hàng
				$( "#totalPriceItem" + productId ).html(jsonResult.totalPriceItem);
				
				$( "#totalCart" ).html(jsonResult.totalCart);
				$( "#totalCart2" ).html(jsonResult.totalCart);
				$( "#totalCart3" ).html(jsonResult.totalCart);
			},
			error: function(jqXhr, textStatus, errorMessage) {
				
			}
		});
	}
	</script>
</body>

</html>