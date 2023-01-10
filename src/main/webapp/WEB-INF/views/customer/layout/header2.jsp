<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<header>
	<div class="content_header">
		<div class="container_header">
			<div class="logo">
				<a href=""> <img src="${base}/img/logo.png">
				</a>
			</div>
			<div class="container">
				<ul class="menu_header">
					<li><a href="${base }/home">Trang chủ</a></li>
					<li><a href="">Giới thiệu</a></li>
					<li><a href="${base }/product" class="active">Sản phẩm</a></li>
					<li><a href="">Sự kiện</a></li>
					<li><a href="">Chính sách</a></li>
					<li><a href="">Liên hệ</a></li>
				</ul>
			</div>
			<div class="button-contact">

				<div class="buttom">
					<form method="GET" action="${base }/product" id="form-search">
						<input type="text" id="keyword" name="keyword"
							placeholder="Từ khóa tìm kiếm" value="${ps.keyWord }">
						<button type="submit" id="btnSearch" name="btnSearch"
							value="Search">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</form>
				</div>
				<form action="${base}/cart/view" style="display: flex; border: 0px">

					<button type="submit" class="icon_cart"
						style="border: 0px; background-color: white ">
						<img src="${base}/img/gio_hang.png"><span class="quantity"
							id="totalCartItemId">${totalItems}</span>
					</button>
				</form>
			</div>
		</div>
	</div>

</header>
