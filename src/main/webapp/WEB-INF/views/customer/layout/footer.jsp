<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<!-- Footer-->
<footer>
	<div class="container container_footer">
		<div class="info_company">
			<div class="logo_footer">
				<img src="${base}/img/logo_footer.png">
			</div>
			<div class="name">Tiệm hoa tươi Swan Florist</div>
			<div class="text">
				<img src="${base}/img/vi_tri.png"> Số 20 Ngõ 30, Nguyễn Thị
				Định, Hà Nội
			</div>
			<div class="text">
				<img src="${base}/img/dien_thoai_trang.png"> Hotline: 09230
				55555
			</div>

			<div class="text">
				<img src="${base}/img/email.png"> Email: swanflorist@gmail.com
			</div>
		</div>

		<div class="content_footer">
			<div class="menu_footer">
				<div class="title">
					<div class="tieude">Quy định và bảo mật</div>
					<ul class="text">
						<li><a href="">Chính sách và quy định chung</a></li>
						<li><a href="">Bảo mật thông tin</a></li>
						<li><a href="">Tin tức</a></li>
						<li><a href="">Liên hệ</a></li>
					</ul>
				</div>
			</div>
			<div class="menu_footer">
				<div class="title">
					<div class="tieude">Chính sách mua hàng</div>
					<ul class="text">
						<li><a href="">Quy định và hình thức thành toán</a></li>
						<li><a href="">Vận chuyển / giao nhận</a></li>
						<li><a href="">Đổi trả hàng và hoàn tiền</a></li>
						<li><a href="">Sản Phẩm nổi bật 4</a></li>
					</ul>
				</div>
			</div>
			<div class="menu_footer">
				<div class="title">
					<div class="tieude">Mạng xã hội</div>
					<ul>
						<li><a href=""><img src="${base}/img/mang_xa_hoi.png"></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</footer>
<div id="copy-right">© 2022 Bản quyền thuộc về Swan Florist. All
	Right Reserved.</div>
