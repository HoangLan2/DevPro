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

			<div class="form-group">
				<label>Họ</label>
				<sf:input path="firstName" name="firstname" id="input_firstname"
					class="form-control"></sf:input>
			</div>
			<div class="form-group">
				<label>Tên</label>
				<sf:input path="lastName" name="lastname" id="input_lastname"
					class="form-control"></sf:input>
			</div>
			<div class="form-group ">
				<label>Biệt danh</label>
				<sf:input path="nickName" name="nickname" id="input_nickname"
					class="form-control"></sf:input>
			</div>
			<div class="form-group">
				<label>Email</label>
				<sf:input path="email" name="email" id="input_email"
					class="form-control"></sf:input>
			</div>
			<div class="form-group">
				<label>Mật khẩu</label>
				<sf:password path="password" showPassword="false" name="password"
					id="input_password" class="form-control"></sf:password>
			</div>
			<div class="form-group">
				<label>Ngày Sinh</label>
				<sf:input path="dateOfBirth" name="date" id="input_date"
					class="form-control"></sf:input>
			</div>
			<div class="form-group">
				<label>Giới tính</label>
				<div style="font-size: 16px; font-weight: bold">
					Nam
					<sf:radiobutton path="gender" value="Male" />
					Nữ
					<sf:radiobutton path="gender" value="Female" />
					Khác
					<sf:radiobutton path="gender" value="Other" />
				</div>
			</div>
			<div class="form-group formdiv">
				<label>Số điện thoại</label>
				<sf:input path="mobile" name="phone" id="input_phone"
					class="form-control"></sf:input>
			</div>
			<div class="form-group formdiv">
				<label>Địa chỉ</label>
				<sf:textarea path="address" name="address" id="input_address"
					class="form-control"></sf:textarea>
			</div>
			<div class="button-form">
				<button type="submit" class="btn btn-register">Đăng ký</button>
			</div>
			<div class="button-form">
				<button type="button" class="btn btn-register">reset</button>
			</div>

			<div>${message }</div>

			<div class="form-group request">
				Bạn đã có tài khoản <a href="../layouts/login.html">Đăng nhập</a>
			</div>

		</sf:form>
	</div>


	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
</body>

</html>