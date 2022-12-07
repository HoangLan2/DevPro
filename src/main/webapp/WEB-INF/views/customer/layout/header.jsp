 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <header>
        <div class="container">
            <div class="content_header">
                <div class="logo">
                    <a href="">
                        <img src="${base}/img/logo.png">
                    </a>
                </div>
                <div class="container">
                    <div class="c">
                        <ul class="menu_header">
                            <li><a href="${base }/home" class="active">Trang chủ</a></li>
                            <li><a href="">Giới thiệu</a></li>
                            <li><a href="${base }/product">Sản phẩm</a></li>
                            <li><a href="">Sự kiện</a></li>
                            <li><a href="">Chính sách</a></li>
                            <li><a href="${base }/contact">Liên hệ</a></li>
                        </ul>

                        <div class="buttom">
                            <form method="GET" action="" id="form-search">
                                <input type="text" name="keyword" placeholder="Từ khóa tìm kiếm">
                                <button type="submit" class="btn-search"><i
                                        class="fa-solid fa-magnifying-glass"></i></button>
                            </form>
                            <div class="sign_inout">
                                <a href="${base }/login">Đăng nhập/</a>
                                <a href="${base }/register">Đăng ký</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </header>