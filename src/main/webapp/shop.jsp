<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:useBean id="cate" class="dao.DAO" scope="request"></jsp:useBean>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado - Furniture Ecommerce Template | Shop</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">
 
<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="scss/style.css">

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

		<div class="shop_sidebar_area " style="margin-left:286px; position:fixed">

			<!-- ##### Single Widget ##### -->
			<div class="widget catagory mb-50">
				<!-- Widget Title -->
				<h6 class="widget-title mb-30">Catagories</h6>

				<!--  Catagories  -->
				<div class="catagories-menu">
					<ul>
						<c:forEach items="${cate.listCategory}" var="c" >
							<li class="${tag == c.cid ? "active": ""}"><a href="category?cid=${c.cid }">${c.cname}</a></li>
						</c:forEach>
						
					</ul>
				</div>
			</div>

		
			
			<div class="widget price mb-50">
				<!-- Widget Title -->
				<h6 class="widget-title mb-30">Price</h6>

				<div class="widget-desc">
					<div class="slider-range">
						<div data-min="10" data-max="1000" data-unit="$"
							class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"
							data-value-min="10" data-value-max="1000" data-label-result="">
							<div class="ui-slider-range ui-widget-header ui-corner-all"></div>
							<span class="ui-slider-handle ui-state-default ui-corner-all"
								tabindex="0"></span> <span
								class="ui-slider-handle ui-state-default ui-corner-all"
								tabindex="0"></span>
						</div>
						<div class="range-price">$10 - $1000</div>
					</div>
				</div>
			</div>
		</div>

		<div class="amado_product_area section-padding-100" style="margin-left:545px">
			<div class="container-fluid">


				<div class="row">

					<!-- Single Product Area -->
					<c:forEach items="${listPani}" var="p">
						<div class="col-12 col-sm-6 col-md-12 col-xl-6" >
							<div class="single-product-wrapper">
								<!-- Product Image -->
								<div class="product-img" >
									<img src="${p.image}" alt="" style="width:421px;height:421px">
									<%-- <!-- Hover Thumb -->
									<img class="hover-img" src="${p.image}" alt=""> --%>
								</div>

								<!-- Product Description -->
								<div
									class="product-description d-flex align-items-center justify-content-between">
									<!-- Product Meta Data -->
									<div class="product-meta-data">
										<div class="line"></div>
										<p class="product-price">${p.price}$</p>
										<a href="detail?pid=${p.pid }">
											<h6>${p.pname}</h6>
										</a>
									</div>
									<!-- Ratings & Cart -->
									<div class="ratings-cart text-right">
										<div class="ratings">
											<i class="fa fa-star" aria-hidden="true"></i> <i
												class="fa fa-star" aria-hidden="true"></i> <i
												class="fa fa-star" aria-hidden="true"></i> <i
												class="fa fa-star" aria-hidden="true"></i> <i
												class="fa fa-star" aria-hidden="true"></i>
										</div>
										
										<div class="cart">
											<a href="add-to-cart?action=add&pid=${p.pid }" data-toggle="tooltip"
												data-placement="left" title="Add to Cart"><img
												src="img/core-img/cart.png" alt=""></a>
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
</div>

					<div class="row">
					
						<div class="col-12">
							<!-- Pagination -->
							<nav aria-label="navigation">
								<ul class="pagination justify-content-end mt-50">
								 <c:forEach begin="1" end="${page }" var="i">
									<li class="page-item ${active == i ? "active" : ""}"><a class="page-link" href="panigation?index=${i}">0${i}.</a></li>
									
									</c:forEach>
									 <c:forEach  begin="1" end="${pageCate }" var="i">
									<li class="page-item ${activeCate == i ? "active" : ""}"><a class="page-link" href="category?index=${i}">0${i}.</a></li>
									
									</c:forEach> 
								</ul>
							</nav>
						</div>
					 
					</div>
				</div>
			</div>
		</div>
		</div>
		<!-- ##### Main Content Wrapper End ##### -->

		<!-- ##### Newsletter Area Start ##### -->
		<section class="newsletter-area section-padding-100-0">
			<div class="container">
				<div class="row align-items-center">
					<!-- Newsletter Text -->
					<div class="col-12 col-lg-6 col-xl-7">
						<div class="newsletter-text mb-100">
							<h2>
								Subscribe for a <span>25% Discount</span>
							</h2>
							<p>Nulla ac convallis lorem, eget euismod nisl. Donec in
								libero sit amet mi vulputate consectetur. Donec auctor interdum
								purus, ac finibus massa bibendum nec.</p>
						</div>
					</div>
					<!-- Newsletter Form -->
					<div class="col-12 col-lg-6 col-xl-5">
						<div class="newsletter-form mb-100">
							<form action="#" method="post">
								<input type="email" name="email" class="nl-email"
									placeholder="Your E-mail"> <input type="submit"
									value="Subscribe">
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- ##### Newsletter Area End ##### -->

    <jsp:include page="footer.jsp"></jsp:include>

		<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
		<script src="js/jquery/jquery-2.2.4.min.js"></script>
		<!-- Popper js -->
		<script src="js/popper.min.js"></script>
		<!-- Bootstrap js -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Plugins js -->
		<script src="js/plugins.js"></script>
		<!-- Active js -->
		<script src="js/active.js"></script>
</body>

</html>
