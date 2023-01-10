
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
<title>Thêm tài khoản</title>

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
					mới tài khoản</h1>

				<div>${message }</div>
				<div>${notifi }</div>

				<sf:form method="post" action="${base}/admin/add-user"
					modelAttribute="users">

					<sf:hidden path="Id" />

					<div class="form-group mb-2">
						<label for="userName">Tên người dùng</label>
						<sf:input path="userName" autocomplete="off" type="text"
							class="form-control" id="userName" placeholder="tên người dùng"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="password">Mật khẩu</label>
						<sf:input type="password" autocomplete="off" path="passWord"
							class="form-control" id="passWord" placeholder="mật khẩu"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="email">Email</label>
						<sf:input type="email" autocomplete="off" path="email"
							class="form-control" placeholder="email" id="email" rows="3"
							required="required"></sf:input>
					</div>

					<div class="form-group mb-2">
						<label for="phone">Số điện thoại</label>
						<sf:input autocomplete="off" path="phone"
							class="form-control summernote" id="phone" rows="3"
							required="required"></sf:input>
					</div>

					<div class="form-group">
						<label for="role">Loại tài khoản </label><br> <select
							class="form-control" id="roleId" name="role">
							<option value="ADMIN">ADMIN</option>
							<option value="GUEST">GUEST</option>
						</select>
					</div>

					<div style="margin-top: 50px">
						<a href="/admin/home" class="btn btn-secondary active"
							role="button" aria-pressed="true">Quay lại</a>
						<button type="submit" class="btn btn-primary" id="btn">Lưu</button>
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
