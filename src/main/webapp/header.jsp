
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100" style="position: sticky; top: 0">
	<div class="search-close">
		<i class="fa fa-close" aria-hidden="true"></i>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="search-content">
					<form action="search" method="get">
						<input type="search" name="name" id="search"
							placeholder="Type your keyword...">
						<button type="submit">
							<img src="img/core-img/search.png" alt="">
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Search Wrapper Area End -->

<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

	<!-- Mobile Nav (max width 767px)-->
	<div class="mobile-nav">
		<!-- Navbar Brand -->
		<div class="amado-navbar-brand">
			<a href="ShopServlet"><img src="img/core-img/logo.png" alt=""></a>
		</div>
		<!-- Navbar Toggler -->
		<div class="amado-navbar-toggler">
			<span></span><span></span><span></span>
		</div>
	</div>

	<!-- Header Area Start -->
	<header class="header-area clearfix" style="position:fixed">
		<!-- Close Icon -->
		<div class="nav-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<!-- Logo -->
		<div class="logo">
			<a href="ShopServlet"><img src="img/core-img/logo.png" alt=""></a>
		</div>
		
		<!-- Cart Menu -->
		<div class="cart-fav-search mb-100">
		
			<a href="ShopServlet" class="cart-nav" ><img src="img/core-img/shop.png" style="width:20px" alt="">
				Shop
			</a> 
			
			
			<a href="cart" class="cart-nav"><img src="img/core-img/cart.png" alt="">
				Cart <span>(${sessionScope.cart.size() })</span>
			</a> 
			
		
			
			<a href="#" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> 
				Favourite
			</a> 
			<a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> 
				Search
			</a>
			
			<!-- Tô Thị Quyên 19130187  -->
			<c:if test="${sessionScope.user == null}"> 
			<a href="login.jsp" class="login-nav"><img src="img/core-img/login.png" alt=""> 
				Login
			</a>
			<!-- Tô Thị Quyên 19130187  -->
			</c:if>
			<c:if test="${sessionScope.user != null }">
			<a href="Logout" class="logout-nav"><img src="img/core-img/logout.png" alt=""> 
				Logout
			</a>
			</c:if>
			<!-- Tô Thị Quyên 19130187 phân quyền  -->
			<c:if test="${sessionScope.user.isAd == 1 }">
			<a href="managerproduct?action=load" class="mProduct-nav"  >
				Manager Product
			</a>
			<a href="signupAdmin.jsp" class="mUser-nav" >
				SignUp Admin
			</a> 
			</c:if>
		</div>
		<!-- Social Button -->
		<div class="social-info d-flex justify-content-between">
			<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
		</div>
	</header>
	<!-- Header Area End -->