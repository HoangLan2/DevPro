<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">Admin</div>
	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Biểu đồ</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Quản lý danh mục</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${base }/admin/product/list">Quản lý sản phẩm</a> 
		
		<c:if test="${isAdminSaleOrder }">
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Quản lý đơn hàng</a>	
		</c:if>
		 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Quản lý lượt thích</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Quản lý fellback</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Subcrible</a>
	</div>
</div>