<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <div class="wrapper">
        <h2>Đăng nhập</h2>
        <h3>Chào mừng bạn đến với Swan Florist!</h3>
        <form id="form_register" method="POST" action="">
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" id="input_email" class="form-control">
            </div>
            <div class="form-group">
                <label>Mật khẩu</label>
                <input type="password" name="password" id="input_password" class="form-control">
            </div>
            <div class="button-form">
                <button type="button" class="btn btn-register">Đăng nhập</button>
            </div>
            <div class="form-group request">Bạn chưa có tài khoản? <a href="../layouts/register.html">Đăng ký</a></div>
        </form>
    </div>

    <script src="../js/login.js"></script>
</body>

</html>