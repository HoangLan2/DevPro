<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<div class="content">
						<div class="name_pro">Sản phẩm</div>
						<div class="price_pro">Giá</div>
						<div class="amount_pro">Số lượng</div>
						<div class="totle_pro">Tạm tính</div>
					</div>
					<hr>
					<div class="content_2">
						<div>
							<img src="${base}/img/san_pham_gio_hang.png">
						</div>
						<div class="name_pro_detail">Địa lan</div>
						<div class="price_pro_detail">350.000đ</div>
						<div class="amount_pro_detail">
							<input aria-label="quantity" class="input-qty" max="10" min="1"
								name="" type="number" value="">

						</div>
						<div class="totle_pro_detail">350.000đ</div>
					</div>
					<hr>
				</div>

				<div class="summary">
					<div style="font-size: 18px; color: #666666; font-weight: bold;">Cộng
						giỏ hàng</div>
					<hr>
					<div class="provisional">
						<div style="margin-right: 180px;">Tạm tính</div>
						<div style="font-weight: bold;">350.000đ</div>
					</div>
					<hr>
					<div class="provisional">
						<div style="margin-right: 210px; font-weight: bold;">Tổng</div>
						<div style="font-weight: bold; color: #cc9933;">350.000đ</div>
					</div>
					<form method="GET" action="">
						<button type="submit" class="btn-submit">Tiến hành thanh
							toán</button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>

</html>