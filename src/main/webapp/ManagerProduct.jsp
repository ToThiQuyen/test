
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:useBean id="cate" class="dao.DAO" scope="request"></jsp:useBean>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manager Product</title>
<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/manager.css" rel="stylesheet" type="text/css" />

<style>
img {
	width: 130px;
	height: 120px;
}
</style>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title" style="background: #fbb710">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Manage <b>Product</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
								New Product</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
						<th>ID</th>
						<th>Name</th>
						<th>Image</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listPani }" var="p">
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
							<td>${p.pid }</td>
							<td>${p.pname }</td>
							<td><img src="${p.image }"></td>
							<td>${p.price }$</td>
							<td><a href="formEdit?pid=${p.pid }"
								href="#editModal" class="edit" data-toggle="modal"><i
									class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								<a href="managerproduct?action=delete&pid=${p.pid }"
								class="delete"><i class="material-icons"
									data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				
				<ul class="pagination">
					
					<c:forEach begin="1" end="${page }" var="i">
						<li class="page-item ${active == i ? "active" : ""}" style="background: #fbb710"><a
							class="page-link"   href="managerproduct?action=load&index=${i}">${i}</a></li>

					</c:forEach>
					
				</ul>
			</div>
		</div>
		<a href="ShopServlet" ><button  type="button"
				class="btn btn-primary" style="margin-bottom: 20px;background: #fbb710" >Back to home</button></a>
	</div>
	<!-- Edit Modal HTML -->
	<div id="addModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="managerproduct?action=add" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input name="pname" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Image</label> <input name="image" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Price</label> <input name="price" type="text"
								class="form-control" required>
						</div>
						
						<div class="form-group">
							<label>Description</label>
							<textarea name="description" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Category</label> <select name="cid" class="form-select"
								aria-label="Default select example">
								<c:forEach items="${cate.listCategory }" var="c">
									<option value="${c.cid }">${c.cname }</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success">
					</div>
				</form>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>