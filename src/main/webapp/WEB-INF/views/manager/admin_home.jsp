
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Admin</title>

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />

<!-- COMMON -->
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>

</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<jsp:include page="/WEB-INF/views/manager/layout/header.jsp"></jsp:include>

		<div id="page-content-wrapper">

			<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>

			<div class="container-fluid">
				<div class="container-fluid" style="display: flex; background-color: #2222;">
					<h2 class="mt-4">Admin</h2>
					<img alt="" src="${base}/img/imager_5656.jpg" width="100" height="100" style="margin-left: 20px">
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<jsp:include page="/WEB-INF/views/manager/layout/js.jsp"></jsp:include>

</body>
</html>
