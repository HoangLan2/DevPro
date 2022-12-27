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
	<form action="${base }/product" method="get">
		<input id="page" name="page" class="form-control"
			style="display: none" value="${ps.currentPage }">

		<jsp:include page="/WEB-INF/views/customer/layout/header2.jsp"></jsp:include>
		<main>
			<div class="breadcrumb">
				<ol>
					<li style="margin-right: 10px;"><img src="${base}/img/nha.png"></li>
					<li><a href="${base }/home">Trang chủ</a></li>
					<li>Sản phẩm</li>
				</ol>
			</div>
			<div class="container">
				<div>
					<ul class="menu">
						<c:forEach var="cate" items="${categories }">
							<li value="${cate.id }"><a
								href="${base }/product/${cate.id}">${cate.name } </a></li>
						</c:forEach>

					</ul>
				</div>

				<div class="row">
					<!-- start -->
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
									<div class="price">${pro.priceSale }VNĐ</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- end -->

				</div>
			</div>
			<div class="row" style="width: 100%">
				<div class="col-12 d-flex justify-content-center" >
					<div id="paging">1</div>
				</div>
			</div>
		</main>

		<!-- phân trang -->

	</form>
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

	<!-- JS -->
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>

	<script type="text/javascript">
			$( document ).ready(function() {
				$(function() {
				    $("#paging").pagination({
				    	currentPage: ${products.currentPage}, 	//trang hiện tại
				        items: ${products.totalItems},			//tổng số sản phẩm
				        itemsOnPage: ${products.sizeOfPage}, 	//số sản phẩm trên 1 trang
				        cssStyle: 'dark-theme',
				        onPageClick: function(pageNumber, event) {
				        	$('#page').val(pageNumber);
				        	$('#btnSearch').trigger('click');
						},
				    });
				});
			});			
		</script>
</body>

</html>