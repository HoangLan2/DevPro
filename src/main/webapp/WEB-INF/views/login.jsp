<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Đăng nhập</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>

	<c:if test="${isLogined}">
		<a href="${base }/home"> tài khoản đã đăng nhập</a>
	</c:if>
	<div class="wrapper">
		<h2>Đăng nhập</h2>
		<h3>Chào mừng bạn đến với Swan Florist!</h3>

		<div>${message }</div>
		<form method="POST" action="${base }/perform_login"
			class="form-signin">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<!-- kiểm tra xem đã login thành công hay không, bằng cách kiểm tra request param login_error -->
			<c:if test="${not empty param.login_error}">
				<div class="alert alert-danger" role="alert">Tài khoản không
					tồn tại, thử lại!!!</div>
			</c:if>

			<div class="form-group">
				<!-- bắt buộc name phải đẻ là "username" -->
				<input type="text" name="username" class="form-control"
					placeholder="Username">
			</div>

			<div class="form-group">
				<!-- bắt buộc name phải đẻ là "password" -->
				<input type="password" name="password" class="form-control"
					placeholder="Password">
			</div>
			<!-- <div class="form-group">
				<input type="checkbox" name="remember-me" /> Nhớ mật khẩu
			</div> -->

			<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng
				nhập</button>

			<h4 class="text-center">
				<a href="${base}/register">Tạo tài khoản/<a href="${base}/home">Quay
						lại</a></a>
			</h4>

		</form>
	</div>
	<script src="../js/login.js"></script>
</body>

</html>