<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Subscribe</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="container-sub">
			<img src="${base}/img/san_pham_4.png">
			<div class="content-sub">
				<center>
					<form class ="form-format">
						<div>
							<h3>Let's keep in touch</h3>
						</div>
						<div class="substyle">
							<input type="text" id="id-email" name="ip_email"
								placeholder="email address">
						</div>
						<div class="substyle">
							<button type="button" id="btnsub" onclick="Subscribe_Click()" class="style-btn" >Subscribe</button>
						</div>
						<div class="substyle">
							<button class="nothank">No, thanks</button>
						</div>
					</form>
				</center>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
	<script type="text/javascript">
		function Subscribe_Click() {
			// javascript object
			let data = {
				email :  $( "#id-email" ).val(),
			};
			// json == javascript object
			jQuery.ajax({
				url : "${base}/subscribe-ajax",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(data),

				dataType : "json",
				success : function(jsonResult) {
					alert(jsonResult.statusMessage)
				},
				error : function(jqXhr, textStatus, errorMessage) {
				}
			});
		}
	</script>
</body>
</html>