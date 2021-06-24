<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 

			
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Product</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-dark bg-light mt-5 p-3">
		<div class="main form-group row mt-5">
			<h1 class="text-center"><c:out value="${product.name}"/></h1>
			
			<!-- Left column to display the existing category -->
			<div class="col mt-3 p-3">
				<h5 >Categories</h5>
				<ul class="m3">
		       		<c:forEach items="${product.categories}" var="pCat">
                    	<li><c:out value="${pCat.name}"/></li>
            		</c:forEach>
				</ul>
			</div>
			
			<!-- right column to add categories -->
			<div class="col mt-3 p-3">
				<form:form action="/products/${product.id}/edit" method="post" modelAttribute="product">
					<h5>Add a category</h5>
					<select class="from-select" name="category_id">
						<option selected>Add a category</option>
						<c:forEach items="${availCat}" var="ac">
							<option value="${ac.id}">
								<c:out value="${ac.name}"></c:out>
							</option>
						</c:forEach>
					</select>
					<input type="submit" value="Add" class="btn btn-primary"/>
				</form:form>
			</div>
		</div>

		<!-- footer with links to the dashboard and to logout -->
		<nav class="navbar navbar-expand-lg justify-content-between">
  			<div class="collapse navbar-collapse">
    			<div class="navbar-nav">
      				<a class="nav-item nav-link" href="/dashboard">Dashboard</a>
      				<a class="nav-item nav-link" href="/logout">Logout</a>
    			</div>
  			</div>
		</nav>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>