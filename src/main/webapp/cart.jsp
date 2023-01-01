<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado - Furniture Ecommerce Template | Cart</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">

<link rel="stylesheet" href="scss/style.css">

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="cart-table-area section-padding-100" style="margin-left: 300px">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12 col-lg-8">
					<div class="cart-title mt-50">
						<h2>Shopping Cart</h2>
					</div>

					<div class="cart-table clearfix">
						<table class="table table-responsive">
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sessionScope.cart }" var="cart">
									<tr>
										<td class="cart_product_img"><a href="#"><img
												src="${cart.value.product.image }" alt="Product"></a></td>
										<td class="cart_product_desc">
											<h5>${cart.value.product.pname }</h5>
										</td>
										<td class="price" data-value="${cart.value.product.price }"><span>${cart.value.product.price }$</span></td>
										<td class="qty">
											<div class="qty-btn d-flex">
												<p class="pr-4">Qty</p>
												<div class="quantity">
													<input type="number" class="qty-text mr-1 " min="1"
														value="${cart.value.quantity }" data-value="${cart.key }" name="quantity">
														 
														<a class="mr-1 text-danger"
														href="add-to-cart?action=delete&key=${cart.key }">Xóa</a>
													<span class="ml-2 mt-2 d-block totalPrice">${cart.value.quantity * cart.value.product.price }</span>

												</div>
											</div>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-12 col-lg-4">
					<div class="cart-summary">
						<h5>Cart Total</h5>

						<ul class="summary-table">
							<li><span>subtotal:</span> <span id="subtotal">${cart.value.product.price*cart.value.quantity}$</span></li>
							<li><span>delivery:</span> <span id="delivery">0</span></li>
							<li><span>total:</span> <span id="total">${cart.value.product.price*cart.value.quantity}$</span></li>
						</ul>

						<div class="cart-btn mt-100">
							<a href="checkout?action=load" class="btn amado-btn w-100">Checkout</a>
						</div>
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
	<script src="js/ajax.js"></script>

</body>

</html>