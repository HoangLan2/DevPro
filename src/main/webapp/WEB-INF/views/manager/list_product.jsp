<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- SPRING FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html lang="en">
<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản lý danh sách sản phẩm</title>

<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>

</head>
<body>
	<div class="d-flex" id="wrapper">

		<jsp:include page="/WEB-INF/views/manager/layout/header.jsp"></jsp:include>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<p class="text-left font-weight-bold text-danger text-uppercase"
					style="font-size: 30px">Danh sách sản phẩm</p>
				<form class="form-inline" action="${base }/admin/product/list"
					method="get">

					<input id="page" name="page" class="form-control"
						style="display: none" value="${productSerach.currentPage }">

					<!-- tìm kiếm sản phẩm theo tên danh sách -->
					<div class="d-flex flex-row justify-content-between mt-4">
						<div class="d-flex flex-row">
							<input type="text" id="keyword" name="keyword"
								class="form-control" placeholder="Search"
								style="margin-right: 5px;" value="${ps.keyWord }">

							<!-- tìm kiếm theo danh mục sản phẩm -->
							<select class="form-control" name="categoryId" id="categoryId"
								style="margin-right: 5px;">
								<option value="0">All</option>
								<c:forEach items="${categories}" var="category">
									<option value="${category.id }">${category.name }</option>
								</c:forEach>
							</select>

							<button type="submit" id="btnSearch" name="btnSearch"
								value="Search" class="btn btn-primary">Seach</button>
						</div>
						<div>
							<a class="btn btn-primary mb-1"
								href="${base }/admin/add-products" role="button"> Thêm mới </a>
						</div>
					</div>
					<div></div>
					<!-- danh sách sản phẩm -->
					<table class="table table-hover" style="margin-top: 30px">
						<thead>
							<tr class="bg-info text-white bg-dark">
								<th scope="col">#</th>
								<th scope="col">Tên sản phẩm</th>
								<th scope="col">Giá bán</th>
								<th scope="col">Danh mục</th>
								<!-- <th scope="col">Tình trạng</th> -->
								<th scope="col">Hình ảnh</th>
								<th scope="col">Hoạt động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products.data}" var="product"
								varStatus="loop">
								<tr>
									<th scope="row" width="5%">${loop.index + 1}</th>
									<td>${product.title }</td>
									<td>
										<!-- định dạng tiền tệ --> <fmt:setLocale value="vi_VN"
											scope="session" /> <fmt:formatNumber
											value="${product.price }" type="currency" />
									</td>
									<td>${product.categories.name }</td>
									<%-- <td><span id="_product_status_${product.id} }"> 
									<c:choose>
												<c:when test="${product.status }">
													<input type="checkbox" checked="checked"
														readonly="readonly">
												</c:when>
												<c:otherwise>
													<input type="checkbox" readonly="readonly">
												</c:otherwise>
									</c:choose>
									</span>
									</td> --%>
									<td><img src="${base }/upload/${product.avatar }"
										width="100" height="100"></td>
									<td width="15%">
										<div>
											<a class="btn btn-primary"
												href="${base }/admin/edit-products/${product.id}"
												role="button">Edit</a>
											<button type="button" class="btn btn-danger"
												onclick="DeleteProduct(${product.id});">Delete</button>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- phân trang -->
					<div class="row">
						<div class="col-12 d-flex justify-content-center">
							<div id="paging"></div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- JS -->
	<jsp:include page="/WEB-INF/views/manager/layout/js.jsp"></jsp:include>
	<script type="text/javascript">
			
	function DeleteProduct(productId) {
		// tạo javascript object.  
		var data = {
			id: productId,
		};
		
		var answer = window.confirm("Bạn có muốn xóa không?");
		if(answer){
			jQuery.ajax({
				url:  '${base}' + "/admin/del-product/{productId}", //->request mapping
				type: "post",					//-> method type cá»§a Request Mapping	
				contentType: "application/json",//-> ná»i dung gá»­i lÃªn dáº¡ng json
				data: JSON.stringify(data),

				dataType: "json", // kiá»u dá»¯ liá»u tráº£ vá» tá»« Controller
				success: function(jsonResult) {
					location.reload();
				},
				error: function(jqXhr, textStatus, errorMessage) {
					alert("error");
				}
			});
		}
		
	}
	
	
	$( document ).ready(function() {
		$(function() {
		    $("#paging").pagination({
		    	currentPage: ${products.currentPage}, 	//trang hiện tại
		        items: ${products.totalItems},			//tổng số sản phẩm
		        itemsOnPage: ${products.sizeOfPage}, 	//số sản phẩm trên 1 trang
		        cssStyle: 'light-theme',
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
