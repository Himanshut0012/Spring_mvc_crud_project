<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<!-- <h1>This is add product form page</h1> -->

	<div class="container mt-3">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center md-6 offset-md-3">Fill the product
				details</h1>
			<form action="handle-product" method="post">
				<div class="form-group">
					<label for="name">Product name</label> 
					<input
						type="text"
						class="form-control"
						id="name"
						name="name"
						placeholder="Enter project name">
				</div>
				<div class="form-group">
					<label for="name">Product description</label> 
					<textarea
						type="text"
						class="form-control"
						id="description"
						name="description"
						rows="5"
						placeholder="Enter project description"></textarea>
				</div>
				<div class="form-group">
					<label for="name">Product price</label> 
					<input
						type="text"
						class="form-control"
						id="price"
						name="price"
						placeholder="Enter project price">
				</div>
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</form>
			</div>
		</div>
	</div>

</body>
</html>