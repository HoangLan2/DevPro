<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="border-end bg-white" id="sidebar-wrapper">
	<div class=" p-3 .bg-light text-dark">Welcome
		${userLogined.userName }</div>

	<div class="list-group">
		<a
			class="list-group-item list-group-item-action"
			role="button" data-toggle="button" aria-pressed="false" href="#!">Biểu
			đồ</a> <a
			class="list-group-item list-group-item-action list-group-item-light  "
			href="#!">Quản lý danh mục</a> <a
			class="list-group-item list-group-item-action list-group-item-light  "
			href="${base }/admin/product/list">Quản lý sản phẩm</a>

		<c:if test="${isAdminSaleOrder }">
			<a
				class="list-group-item list-group-item-action list-group-item-light  "
				href="#!">Quản lý đơn hàng</a>
		</c:if>

		<a
			class="list-group-item list-group-item-action list-group-item-light  "
			href="${base }/admin/account">Quản lý tài khoản</a> <a
			class="list-group-item list-group-item-action list-group-item-light  "
			href="#!">Quản lý fellback</a> <a
			class="list-group-item list-group-item-action list-group-item-light  "
			href="#!">Subcrible</a> <a
			class="list-group-item list-group-item-action list-group-item-light
			 "
			href="${base }/logout">Đăng xuất</a>
	</div>
</div>