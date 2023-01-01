
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mess = (String) request.getAttribute("mess");

%>

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
					<ul class="nav nav-tabs nav-justified">
						<li ><a href="signup.jsp">Sign up</a></li>
						<li class="active"><a href="#login" role="tab" data-toggle="tab">Log in</a></li>
					</ul>

						<div class="tab-pane active fade in" id="login" methods="post">
							<h2 class="text-uppercase text-center">Log in</h2>
							<form action="Login" id="login" method="POST">
								<%
								if (mess != null) {
								%>
								<div class="alert alert-danger" role="alert">
									<%=mess%>
								</div>
								<%
								}
								%>
								<div class="form-group">

									<input <%if (request.getParameter("username") != null) {%>
										value="<%=request.getParameter("username")%>" <%}%>
										name="username" class="form-control" id="username" required
										data-validation-required-message="Please enter your username "
										autocomplete="off" placeholder="Username...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									
								 <input type="password" name="password" class="form-control"
										id="password" required
										data-validation-required-message="Please enter your password"
										autocomplete="off" placeholder="Password...">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									Log in
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