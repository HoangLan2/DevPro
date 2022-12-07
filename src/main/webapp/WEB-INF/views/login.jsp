<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>

<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>

<style type="text/css">
.error-template {
	padding: 40px 15px;
	text-align: center;
}

.error-actions {
	margin-top: 15px;
	margin-bottom: 15px;
}

.error-actions .btn {
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2 class="form-heading">Log in</h2>
				
				<form method="POST" action="${base }/login_processing_url" class="form-signin">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					
					<!-- kiểm tra xem đã login thành công hay không, bằng cách kiểm tra request param login_error -->
					<c:if test="${not empty param.login_error}">
						<div class="alert alert-danger" role="alert">
							Login attempt was not successful, try again!!!
						</div>
					</c:if>

					<div class="form-group">
						<!-- bắt buộc name phải đẻ là "username" -->
						<input type="text" name="username" class="form-control" placeholder="Username">
					</div>

					<div class="form-group">
						<!-- bắt buộc name phải đẻ là "password" -->
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					
					<!-- <div class="form-group">
						<input type="checkbox" name="remember-me" /> Remember me
					</div> --> 

					<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
					
					<h4 class="text-center">
						<a href="${base}/register">Create an account</a>
					</h4>

				</form>
				
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>
</html>