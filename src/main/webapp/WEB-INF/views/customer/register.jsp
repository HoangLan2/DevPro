<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- sf: spring-form -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Đăng ký</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper">

		<sf:form modelAttribute="registerModel"
			action="${base }/register-spring-form" method="post">
			<h2>Đăng ký</h2>
			<h3>Chào mừng bạn đến với Swan Florist!</h3>

			<div>${message }</div>
			<div>${notifi }</div>
			<div class="form-group">
				<label>Tên</label>
				<sf:input path="userName" name="userName" id="input_userName"
					class="form-control"></sf:input>
				<sf:errors path="userName" style="color: red"></sf:errors>
			</div>

			<div class="form-group">
				<label>Email</label>
				<sf:input path="email" name="email" id="input_email"
					class="form-control"></sf:input>
				<sf:errors path="email" style="color: red"></sf:errors>
			</div>
			<div class="form-group">
				<label>Mật khẩu</label>
				<sf:password path="passWord" showPassword="false" name="password"
					id="input_password" class="form-control"></sf:password>
				<sf:errors path="passWord" style="color: red"></sf:errors>
			</div>

			<%-- <div class="form-group">
				<label>Giới tính</label>
				<div style="font-size: 16px; font-weight: bold">
					Nam
					<sf:radiobutton path="gender" value="Male" />
					Nữ
					<sf:radiobutton path="gender" value="Female" />
					Khác
					<sf:radiobutton path="gender" value="Other" />
				</div>
			</div> --%>
			<div class="form-group formdiv">
				<label>Số điện thoại</label>
				<sf:input path="phone" name="phone" id="input_phone"
					class="form-control" maxlength="10"></sf:input>
				<sf:errors path="phone" style="color: red"></sf:errors>
			</div>
			<div class="form-group formdiv">
				<label>Địa chỉ</label>
				<sf:textarea path="shippingAddress" name="shippingAddress"
					id="input_address" class="form-control"></sf:textarea>
				<sf:errors path="shippingAddress" style="color: red"></sf:errors>
			</div>
			<div class="button-form">
				<button type="submit" class="btn btn-register">Đăng ký</button>
			</div>
			<div class="button-form">
				<button type="button" class="btn btn-register">reset</button>
			</div>



			<div class="form-group request">
				Bạn đã có tài khoản <a href="${base }/login">Đăng nhập/</a><a
					href="${base}/home">Quay lại</a>
			</div>

		</sf:form>
	</div>


	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>

</html>