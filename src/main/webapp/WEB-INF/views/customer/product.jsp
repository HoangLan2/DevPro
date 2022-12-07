<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Trang sản phẩm</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header2.jsp"></jsp:include>
	<main>
		<div class="breadcrumb">
			<ol>
				<li style="margin-right: 10px;"><img src="${base}/img/nha.png"></li>
				<li><a href="home.html">Trang chủ</a></li>
				<li>Sản phẩm</li>
			</ol>
		</div>

		<div class="container">
			<div>
				<ul class="menu">
					<li><a href="" class="active">Hoa để bàn</a></li>
					<li><a href="">Bó hoa</a></li>
					<li><a href="">Kệ hoa </a></li>
					<li><a href="">Lan hồ điệp</a></li>
				</ul>
			</div>

			<div class="row">
				<!-- start -->
				<c:forEach var="pro" items="${products }">
					<!-- start -->

					<div class="item">
						<div class="info">
							<a href="${base }/detailProduct/${pro.id }"> <img
								src="${base }/upload/${pro.avatar }" width="285" height="289">
							</a>
							<div class="desc_product">
								<h2 class="product_name">
									<a href="">${pro.title }</a>
								</h2>
								<div class="price">${pro.priceSale }đ</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- end -->

			</div>

			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
</body>

</html>