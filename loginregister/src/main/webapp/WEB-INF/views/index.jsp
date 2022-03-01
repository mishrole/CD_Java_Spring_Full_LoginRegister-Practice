<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login | Register</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<!-- <div class="pt-2 pb-4"><a href="/">Go back</a></div> -->
				
				<div class="d-flex flex-column justify-content-between align-items-center pb-4">
					<h3 class="text-primary">Welcome!</h3>
					<p>Join our growing community.<p>
				</div>
				
				<div class="row">
				<!-- Register -->
					<div class="col-12 col-lg-6">
						<div class="card mb-4">
							<div class="card-body">
								<h3 class="pt-2 pb-3">Register</h3>
								<form:form action="/register" method="POST" id="validate" modelAttribute="newUser">
									<div class="row mx-auto">
									
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="username" type="text" class="form-control requires-validation validate-save" name="username" id="username" />
												<div class="invalid-feedback"></div>
												<form:errors path="username" class="text-danger backend-validation" />
												<form:label for="username" path="username">User Name</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="email" type="email" class="form-control requires-validation validate-save" name="email" id="email" />
												<div class="invalid-feedback"></div>
												<form:errors path="email" class="text-danger backend-validation" />
												<form:label for="email" path="email">Email</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="password" type="password" class="form-control requires-validation validate-save" name="password" id="password" />
												<div class="invalid-feedback"></div>
												<form:errors path="password" class="text-danger backend-validation" />
												<form:label for="password" path="password">Password</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="confirm" type="password" class="form-control requires-validation validate-save" name="confirm" id="confirm" />
												<div class="invalid-feedback"></div>
												<form:errors path="confirm" class="text-danger backend-validation" />
												<form:label for="confirm" path="confirm">Confirm Password</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="d-flex align-items-center justify-content-end">
												<button class="btn btn-primary" type="submit" value="Submit">Sign Up</button>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					
					<!-- Login -->
					<div class="col-12 col-lg-6">
						<div class="card mb-4">
							<div class="card-body">
								<h3 class="pt-2 pb-3">Login</h3>
								<form:form action="/login" method="POST" id="validate" modelAttribute="newLogin">
									<div class="row mx-auto">
									
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="email" type="email" class="form-control requires-validation validate-save" name="email" id="email" />
												<div class="invalid-feedback"></div>
												<form:errors path="email" class="text-danger backend-validation" />
												<form:label for="email" path="email">Email</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-floating mb-3">
												<form:input path="password" type="password" class="form-control requires-validation validate-save" name="password" id="password" />
												<div class="invalid-feedback"></div>
												<form:errors path="password" class="text-danger backend-validation" />
												<form:label for="password" path="password">Password</form:label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="d-flex align-items-center justify-content-end">
												<button class="btn btn-primary" type="submit" value="Submit">Sign in</button>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/validateHelper.js"></script>
	<script src="/js/validateForm.js"></script>
</body>
</html>