<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Chi tiết sản phẩm</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header2.jsp"></jsp:include>
	<main>
		<div class="breadcrumb">
			<ol>
				<li style="margin-right: 10px;"><img src="${base}/img/nha.png"></li>
				<li><a href="product.html">Sản phẩm</a></li>
				<li>Chi tiết sản phẩm</li>
			</ol>
		</div>

		<div class="container detailPro">

			<div class="media">
				<img class="align-self-center mr-5"
					src="${base }/upload/${product.avatar }" width="285" height="289">
				<div class="media-body">
					<h5 class="mt-2" style="font-weight: bolder;">${product.title }</h5>
					<p>${product.details }</p>
					<p class="mb-2">${product.shortDes }</p>
					<h6 style="font-weight: bold; margin-top: 20px;">Số lượng</h6>
					<div class="buttons_added">
						<input aria-label="quantity" class="input-qty" max="10" min="1"
							name="" type="number" value="">
						<div class="total">100.000 VNĐ</div>
					</div>
					<form>
						<button class="addCart" type="submit" form="nameform"
							value="Submit">Thêm vào giỏ hàng</button>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>
</html>