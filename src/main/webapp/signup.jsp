
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html lang="en"></html>
<head>
<title>Amado - Furniture Ecommerce Template | LogIn-SignUp</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!--<link rel="stylesheet" href="scss/style.css">-->
<link rel="stylesheet" href="css/login.css">
</head>

<body>
<!-- Tô Thị Quyên 19130187  -->
	<div id="form">
		<div class="container">
			<div
				class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
				<div id="userform">
					<ul class="nav nav-tabs nav-justified" role="tablist">
						<li class="active"><a href="#signup" role="tab"
							data-toggle="tab">Sign up</a></li>
						<li ><a href="login.jsp">Log in</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active fade  in" id="signup" method="post">
							<h2 class="text-uppercase text-center">Sign Up for Free</h2>
							<!-- Gọi đến signup servlet truyền action = customer -> hàm đăng kí cho customer  -->
							<form action="SignUp?action=customer" id="signup" method="post">
							
							<!-- báo lỗi biến erorr set bên signup servlet -->
								<p class=text-danger>${erorr}</p>
								<div class="form-group" >
									
									 <input name="username" class="form-control" id="username" required
										data-validation-required-message="Please enter your username."
										autocomplete="off" placeholder="Username..">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group" >
									
									 <input name="fullname" class="form-control" id="fullname" required
										data-validation-required-message="Please enter your fullname."
										autocomplete="off" placeholder="Fullname...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group" >
									
									 <input name="phone" class="form-control" id="phone" required
										data-validation-required-message="Please enter your phone."
										autocomplete="off" placeholder="phone...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									 
									 <input type="password" name="pass" class="form-control" id="phone" required
										data-validation-required-message="Please enter your phone number."
										autocomplete="off" placeholder="Password...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									
									 <input type="password" name="repass" class="form-control" id="password"
										required
										data-validation-required-message="Please enter your password"
										autocomplete="off" placeholder="Re-password...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									Sign up
									</button>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>
	<script src="js/jquery/jquery-2.2.4.min.js"></script>

	<!-- Bootstrap js -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<!-- Plugins js -->

</body>