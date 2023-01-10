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
<title>Trang chủ</title>
<meta name='viewport'
	content='width=device-width, initial-scale=1, height= device-height, user-scalable = yes'>

<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<form action="${base }/home" method="get">

		<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
		<main>
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" src="${base}/img/banner1.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="${base}/img/banner2.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="${base}/img/banner3.jpg"
							alt="Third slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" src="${base}/img/banner4.jpg"
							alt="Four slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>


			<div class="container">

				<div class="spm">
					<h5>Sản phẩm mới</h5>
				</div>
				<%-- <form action="${base }/home" method="get"></form> --%>

				<div class="row">
					<c:forEach var="pro" items="${products.data }">
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
									<div class="price" style="font-family: Arial">

										<fmt:setLocale value="vi_VN" />
										<strong><fmt:formatNumber value="${pro.priceSale}"
												type="currency" /></strong> VNĐ

									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<div id="carouselExampleSlidesOnly" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active ">
							<img class="d-block w-100" src="${base}/img/slide1.png"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="${base}/img/slide2.png"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="${base}/img/slide3.png"
								alt="Third slide">
						</div>
					</div>
				</div>


				<div class="spm">
					<h5>Sản phẩm bán chạy</h5>
				</div>

				<div class="slider-box _clearfix slickk">

					<div class="slick-slider">
						<c:forEach var="proHot" items="${productHot.data }">
							<div class="item">
								<div class="info">
									<a href="${base }/detailProduct/${proHot.id }"> <img
										src="${base }/upload/${proHot.avatar }" width="285"
										height="289">
									</a>
									<div class="desc_product">
										<h2 class="product_name">
											<a href="">${proHot.title }</a>
										</h2>
										<div class="price">
											<fmt:setLocale value="vi_VN" />
											<strong><fmt:formatNumber
													value="${proHot.priceSale }" type="currency" /></strong> VNĐ
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</div>
					<div class="btnPreNex">
						<button class="btnPre">
							<i class="fa-solid fa-chevron-left"></i>
						</button>
						<button type="button" class="btnNext">
							<i class="fa-solid fa-chevron-right"></i>
						</button>

					</div>
				</div>
			</div>
		</main>
	</form>
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>
</html>