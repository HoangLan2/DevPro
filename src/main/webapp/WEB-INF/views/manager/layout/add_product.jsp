
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
<title>Quản lý sản phẩm</title>

<!-- COMMON -->
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>

<!-- Core theme CSS (includes Bootstrap)-->

<jsp:include page="/WEB-INF/views/manager/layout/js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
	<div class="d-flex" id="wrapper">
		<jsp:include page="/WEB-INF/views/manager/layout/header.jsp"></jsp:include>

		<div id="page-content-wrapper">

			<!-- Page content-->
			<div class="container-fluid">

				<h1 class="text-left font-weight-bold text-danger text-uppercase">Thêm
					mới sản phẩm</h1>

				<sf:form method="post" action="${base}/admin/add-products"
					modelAttribute="product" enctype="multipart/form-data">

					<sf:hidden path="Id" />

					<div class="form-group">
						<label for="category">Danh mục</label>
						<sf:select path="categories.id" class="form-control" id="category">
							<sf:options items="${categories }" itemValue="id"
								itemLabel="name" />
						</sf:select>
					</div>

					<div class="form-group mb-2">
						<label for="title">Tên sản phẩm</label>
						<sf:input path="title" autocomplete="off" type="text"
							class="form-control" id="title" placeholder="tên sản phẩm"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="price">Giá nhập</label>
						<sf:input type="number" autocomplete="off" path="price"
							class="form-control" id="price" placeholder="0"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="priceSale">Giá bán</label>
						<sf:input type="number" autocomplete="off" path="priceSale"
							class="form-control" id="priceSale" placeholder="0"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="short_description">Mô tả</label>
						<sf:textarea autocomplete="off" path="shortDes"
							class="form-control" placeholder="mô tả ngắn gọn"
							id="short_description" rows="3" required="required"></sf:textarea>
					</div>

					<div class="form-group mb-2">
						<label for="detail_description">Mô tả chi tiết</label>
						<sf:textarea autocomplete="off" path="details"
							class="form-control summernote" id="detail_description" rows="3"
							required="required"></sf:textarea>
					</div>

					<div class="form-group">
						<label for="fileProductAvatar">Avatar</label> <input
							id="fileProductAvatar" name="productAvatar" type="file"
							class="form-control-file">
					</div>
					<div class="form-group mb-2">
						<img alt="" style="width: 100px; height: 100px;"
							src="${base }/upload/${product.avatar}">
					</div>
					<div class="form-group mb-2">
						<label for="fileProductPictures">Ảnh kèm theo</label> <input
							id="fileProductPictures" name="productPictures" type="file"
							class="form-control" multiple="multiple">
					</div>
					<div class="form-group mb-2">
						<c:forEach items="${product.productImages }" var="productImage">
							<img alt="" style="width: 100px; height: 100px;"
								src="${base }/upload/${productImage.path}">
						</c:forEach>

					</div>

					<div style="margin-top: 50px">
						<a href="/admin/product/list" class="btn btn-secondary active"
							role="button" aria-pressed="true">Quay lại</a>
						<button type="submit"  class="btn btn-primary" id="btn">Lưu
							sản phẩm</button>
					</div>
				</sf:form>

			</div>
		</div>
	</div>

	<!-- internal javascript -->
	<script type="text/javascript">
		$(document).ready(function() {

			$('#detail_description').summernote({
				placeholder : 'Mô tả chi tiết',
				tabsize : 2,
				height : 120,
			});
		});
	</script>

</body>
</html>
