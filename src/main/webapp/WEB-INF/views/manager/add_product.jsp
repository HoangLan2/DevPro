
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
<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>

</head>
<body>
	<div class="d-flex" id="wrapper">
		<jsp:include page="/WEB-INF/views/manager/layout/header.jsp"></jsp:include>

		<div id="page-content-wrapper">

			<!-- Page content-->
			<div class="container-fluid">

				<h1 class="text-left font-weight-bold text-danger text-uppercase">Thêm
					mới sản phẩm</h1>

				<sf:form modelAttribute="addProductModel"
					action="${base }/admin/add-product-spring-from" method="post">

					<div class="form-group mb-2">
						<label for="productId">Mã sản phẩm</label>
						<sf:input path="id" id="productId" class="form-control"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="category">Danh mục</label>
						<sf:input path="categoryId" id="productId" class="form-control"></sf:input>
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

					<div class="form-group mb-2">
						<label for="fileProductAvatar">Ảnh</label> <sf:input path="avatar"
							id="fileProductAvatar" name="productAvatar" type="file"
							class="form-control"></sf:input>
					</div>

					<!-- <div class="form-group mb-2">
						<label for="fileProductPictures">Ảnh kèm theo</label> <input
							id="fileProductPictures" name="productPictures" type="file"
							class="form-control" multiple="multiple">
					</div> -->

					<div class="form-group" style="margin-top: 30px">
						<label for="createdDate">Ngày tạo:</label>
						<sf:input path="createdDate" />
					</div>
					<div style="margin-top: 50px">
						<a href="/admin/product/list" class="btn btn-secondary active"
							role="button" aria-pressed="true">Quay lại</a>
						<button type="submit" class="btn btn-primary">Thêm sản
							phẩm</button>
					</div>
				</sf:form>


				<%-- 			<sf:form method="post" action="">

						<div class="form-group mb-2">
							<label for="productId">Mã sản phẩm</label>
							<sf:input path="id" id="productId" class="form-control"></sf:input>
						</div>

						<div class="form-group mb-2">
							<label for="category">Danh mục</label>
							<sf:select path="categories.id" class="form-control"
								id="category">
								<sf:options items="${categories }" itemValue="id"
									itemLabel="name" />
							</sf:select>
						</div>

						<div class="form-group mb-2">
							<label for="title">Tên sản phẩm</label>
							<sf:input path="title" autocomplete="off" type="text"
								class="form-control" id="title" placeholder="Title"
								required="required"></sf:input>
						</div>

						<div class="form-group mb-2">
							<label for="price">Giá nhập</label>
							<sf:input type="number" autocomplete="off" path="price"
								class="form-control" id="price" placeholder="Price"
								required="required"></sf:input>
						</div>

						<div class="form-group mb-2">
							<label for="priceSale">Giá bán</label>
							<sf:input type="number" autocomplete="off" path="priceSale"
								class="form-control" id="priceSale" placeholder="Price sale"
								required="required"></sf:input>
						</div>

						<div class="form-group mb-2">
							<label for="short_description">Mô tả</label>
							<sf:textarea autocomplete="off" path="shortDes"
								class="form-control" placeholder="Short Description"
								id="short_description" rows="3" required="required"></sf:textarea>
						</div>

						<div class="form-group mb-2">
							<label for="detail_description">Mô tả chi tiết</label>
							<sf:textarea autocomplete="off" path="details"
								class="form-control summernote" id="detail_description" rows="3"
								required="required"></sf:textarea>
						</div>

						<div class="form-group form-check mb-2">
							<sf:checkbox path="isHot" class="form-check-input" id="isHot" />
							<label class="form-check-label" for="isHot">Sản phẩm hot?</label>
						</div>

						<div class="form-group mb-2">
							<label for="fileProductAvatar">Ảnh</label> <input
								id="fileProductAvatar" name="productAvatar" type="file"
								class="form-control">
						</div>

						<div class="form-group">
							<img alt="" style="width: 100px; height: 100px;"
								src="${base }/upload/${product.avatar}">
						</div>

						<div class="form-group mb-2">
							<label for="fileProductPictures">Ảnh kèm theo</label> <input
								id="fileProductPictures" name="productPictures" type="file"
								class="form-control" multiple="multiple">
						</div>

						<div class="form-group">
							<c:forEach items="${product.productImages }" var="productImage">
								<img alt="" style="width: 100px; height: 100px;"
									src="${base }/upload/${productImage.path}">
							</c:forEach>
						</div>

						<div class="form-group">
							<label for="createdDate">Ngày tạo:</label>
							<sf:input path="createdDate" />
						</div>

						<a href="/admin/product/list" class="btn btn-secondary active"
							role="button" aria-pressed="true">Quay lại</a>
						<button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
					</sf:form>
 --%>
			</div>
		</div>
	</div>

	<!-- JS -->
	<jsp:include page="/WEB-INF/views/manager/layout/js.jsp"></jsp:include>

	<!-- internal javascript -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#detail_description').summernote();
		});
	</script>

</body>
</html>
