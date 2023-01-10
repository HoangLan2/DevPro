
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<header>

	<div class="content_header">
		<button type="button" id="open_sidebar" onclick="click()"
			style="height: 10%">
			<i class="fa-solid fa-bars"></i>
		</button>
		<div class="container_header">

			<div class="logo">
				<a href=""> <img src="${base}/img/logo.png">
				</a>
			</div>
			<div class="container">
				<div class="c">
					<nav>
						<ul class="menu_header">
							<li><a href="${base }/home" class="active">Trang chủ</a></li>
							<li><a href="">Giới thiệu</a></li>
							<li><a href="${base }/product">Sản phẩm</a></li>
							<li><a href="">Sự kiện</a></li>
							<li><a href="">Chính sách</a></li>
							<li><a href="${base }/contact">Liên hệ</a></li>
						</ul>
					</nav>
					<div class="buttom">
						<form method="GET" action="" id="form-search">
							<input type="text" name="keyword" placeholder="Từ khóa tìm kiếm"
								value="${ps.keyWord }">
							<button type="submit" class="btn-search">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</form>
					</div>

					<div class="sign_inout">
						<c:choose>

							<c:when test="${isLogined}">
								<a href="#">${userLogined.userName }/</a>
								<a href="${base }/logout">Đăng xuất</a>
							</c:when>

							<c:otherwise>
								<a href="${base }/login">Đăng nhập/</a>
								<a href="${base }/register">Đăng ký</a>
							</c:otherwise>

						</c:choose>

					</div>
				</div>
			</div>
		</div>
	</div>

</header>