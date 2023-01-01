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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 130px;
	height: 120px;
}
</style>
<body>
	<div class="container">
		<div id="editModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="managerproduct?action=edit" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Edit Product</h4>
							
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>ID</label> <input value="${product.pid}" name="pid"
									type="text" class="form-control" readonly required>
							</div>
							<div class="form-group">
								<label>Name</label> <input value="${product.pname}" name="pname"
									type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label> <input value="${product.image}"
									name="image" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Price</label> <input value="${product.price}"
									name="price" type="text" class="form-control" required>
							</div>

							<div class="form-group">
								<label>Description</label>
								<textarea name="description" class="form-control" required>${product.descrip}</textarea>
							</div>
							<div class="form-group">
								<label>Category</label> <select name="cid" class="form-select"
									aria-label="Default select example">
									<c:forEach items="${cate.listCategory}" var="c">
										<option value="${c.cid}">${c.cname}</option>
									</c:forEach>
								</select>
							</div>
							
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success">
						</div>
						
					</form>
					
				</div>
			</div>
			<a href="managerproduct?action=load"><button type="button"
									class="btn btn-primary" style="margin-bottom: 20px; margin-left: 270px; background:  #fbb710">Back
									to manager product</button></a>
		</div>



	</div>
	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>