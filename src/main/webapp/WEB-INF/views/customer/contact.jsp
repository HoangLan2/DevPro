<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- sf: spring-form -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        
        <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
        
    </head>
    
    <body>
        
        <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
        
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5">
                
                <!-- Form Contact -->
                <div class="row">
           	 		
			        <div class="col">
			        	
			        	<c:if test="${not empty message }">
				        	<div class="alert alert-primary" role="alert">
								${message }
							</div>
			        	</c:if>
									        				        
			            <div class="card">
			                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Contact us.</div>
			                <div class="card-body">
			                
			                	<!-- cách 1: cách đơn giản -->
			                	<!-- khi click vào submit button thì sẽ tạo 1 request tới Controller dưới dạng POST -->
			                	<!-- nếu method của Form là get thì các giá trị của input sẽ được đẩy theo query-param -->
			                    <%-- <form action="${base }/contact-us" method="post">
			                        <div class="form-group mb-2">
			                            <label for="firstName">Họ và tên</label>
			                            <input type="text" class="form-control" name="fullName" id="idFullName" placeholder="Họ và tên" required>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="email">Địa chỉ Email</label>
			                            <input type="email" class="form-control" name="email" id="idEmail" placeholder="Email" required>
			                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="message">Nội dung liên hệ</label>
			                            <textarea class="form-control" name="message" id="idMessage" rows="6" required></textarea>
			                        </div>
			                        
			                        <div class="mx-auto mb-2">
			                        	<button type="submit" class="btn btn-primary text-right">Submit</button>
			                        </div>
			                    </form> --%>
			                    
			                    <!-- cách 2: Sử dụng sprring-form -->
			                    <!-- bước 1: import thư viện taglib spring-form -->
			                    <!-- bước 2: sử dụng các thẻ spring-form -->
			                    <sf:form modelAttribute="contact" action="${base }/contact-us" method="post" enctype="multipart/form-data">
			                    	<div class="form-group mb-2">
			                            <label for="firstName">Họ</label>
			                            <sf:input path="firstName" class="form-control" name="fullName" id="idFullName" placeholder="Họ và tên"></sf:input>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="lastName">Tên</label>
			                            <sf:input path="lastName" class="form-control" name="lastName" id="idLastName" placeholder="Họ và tên"></sf:input>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="email">Địa chỉ Email</label>
			                            <sf:input path="email" class="form-control" name="email" id="idEmail" placeholder="Email"></sf:input>
			                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="message">Nội dung liên hệ</label>
			                            <sf:textarea path="message" class="form-control" name="message" id="idMessage" rows="6"></sf:textarea>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="uploadFile">Upload file</label>
			                            <input type="file" class="form-control" id="uploadFile" name="attachment"/>			                            
			                        </div>
			                        <div class="mx-auto mb-2">
			                        	<button type="submit" class="btn btn-primary text-right">Submit</button>
			                        </div>
			                    </sf:form>
			                    
			                    <!-- cách 3: sử dụng ajax, submit data mà không cần reload lại trang web -> tăng trải nghiệm người dùng -->
			                    <!-- ajax không sử dụng action của Form để request -->
			                    <%-- <form>
			                        <div class="form-group mb-2">
			                            <label for="firstName">Họ và tên</label>
			                            <input type="text" class="form-control" name="fullName" id="idFullName" placeholder="Họ và tên" required>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="email">Địa chỉ Email</label>
			                            <input type="email" class="form-control" name="email" id="idEmail" placeholder="Email" required>
			                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			                        </div>
			                        <div class="form-group mb-2">
			                            <label for="message">Nội dung liên hệ</label>
			                            <textarea class="form-control" name="message" id="idMessage" rows="6" required></textarea>
			                        </div>			                        
			                        <div class="mx-auto mb-2">
			                        	<button type="button" onclick="saveContact('${base}')" class="btn btn-primary text-right">Submit</button>
			                        </div>
			                    </form> --%>
			                    			                    
			                </div>
			            </div>
			        </div>
			        <div class="col-12 col-sm-4">
			            <div class="card bg-light mb-3">
			                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> Address</div>
			                <div class="card-body">
			                    <p>3 rue des Champs Elysées</p>
			                    <p>75008 PARIS</p>
			                    <p>France</p>
			                    <p>Email : email@example.com</p>
			                    <p>Tel. +33 12 56 11 51 84</p>			
			                </div>			
			            </div>
			        </div>
			    </div>
                
            </div>
        </section>
        
        <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
        
    </body>
    
</html>
