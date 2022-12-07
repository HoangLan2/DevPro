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
<title>Liên hệ</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper">
		<div>
			<c:forEach var="employee" items="${employees}"> Nhân viên: ${employee.maNv } - ${employee.name } <br />
			</c:forEach>
		</div>
		<%-- <form action="${base }/contact" method="post">
			<h2>Liên hệ</h2>

			<div>${message }</div>

			<div class="form-group">
				<label>Tên</label> <input type="text" name="fullname"
					id="input_fullname" class="form-control">
			</div>
			<div class="form-group">
				<label>Email</label> <input type="email" name="email"
					id="input_email" class="form-control">
			</div>
			<div class="form-group">
				<label>Nội dung</label>
				<textarea type="text" name="txtContent" id="txtContent"
					class="form-control txtContent"></textarea>
			</div>
			<div class="button-form">
				<button type="submit" class="btn btn-contact">Submit</button>
			</div>

		</form> --%>

		 <sf:form modelAttribute="contactModel" action="${base }/contact-spring-from" method="post">
			<h2>Liên hệ</h2>
			
			<div class="form-group">
				<label>Họ</label> 
				<sf:input path="firstName" name="firstName"
					id="input_firstname" class="form-control"></sf:input>
			</div>
			
			<div class="form-group">
				<label>Tên</label> 
				<sf:input path="lastName" name="lastName"
					id="input_lastname" class="form-control"></sf:input>
			</div>
			
			<div class="form-group">
				<label>Email</label> 
				<sf:input path="email" name="email"
					id="input_email" class="form-control"></sf:input>
			</div>
			<div class="form-group">
				<label>Nội dung</label>
				<sf:textarea path="message" name="message" id="txtContent"
					class="form-control txtContent"></sf:textarea>
			</div>
			<div class="button-form">
				<button type="submit" class="btn btn-contact">Submit</button>
			</div>

		</sf:form> 

		<!-- Ajax form -->
		<%-- <form>
			<h2>Liên hệ</h2>

			<div>${message }</div>

			<div class="form-group">
				<label>Tên</label> <input type="text" name="firstname"
					id="input_firstname" class="form-control">
			</div>
			<div class="form-group">
				<label>Tên</label> <input type="text" name="lastname"
					id="input_lastname" class="form-control">
			</div>
			<div class="form-group">
				<label>Email</label> <input type="email" name="email"
					id="input_email" class="form-control">
			</div>
			<div class="form-group">
				<label>Nội dung</label>
				<textarea type="text" name="txtContent" id="txtContent"
					class="form-control txtContent"></textarea>
			</div>
			<div class="button-form">
				<button type="button" onclick="Submit_Click()"
					class="btn btn-contact">Submit</button>
			</div>

		</form> --%>

	</div>

	<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>

	<script type="text/javascript">
		function Submit_Click() {
			// javascript object

			let data = {
				firstName :  $( "#input_firstname" ).val(),
				lastName :  $( "#input_lastname" ).val(),
				email :  $( "#input_email" ).val(),
				message : $( "#txtContent" ).val(),
			};

			// json == javascript object
			jQuery.ajax({
				url : "${base}/contact-ajax",
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