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
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
    <div class="container mt-5 p-3">
    	<!-- Show all products -->
        <div class="main form-group row border border-dark">
			<table class="table table-striped">
				<thead>
					<th>Product</th>
					<th>Category</th>
					<th>Action</th>
				</thead>
		    	<tbody>
		       		<c:forEach items="${products}" var="p">
		       			<tr>
                    		<td><c:out value="${p.name}" /></td>
							<td>
								<ul class="m3">
		       						<c:forEach items="${p.categories}" var="pCat">
                    					<li><c:out value="${pCat.name}"/></li>
            						</c:forEach>
								</ul>
							</td>
                    		<td><a href="/products/${p.id}">Edit product</a></td>
		       			</tr>
		       		</c:forEach>
		    	</tbody>
			</table>
        </div>

        <!-- Show all categories -->
        <div class="main form-group row mt-3 border border-dark">
			<table class="table table-striped">
				<thead>
					<th>Category</th>
					<th>Product</th>
					<th>Action</th>
				</thead>
		    	<tbody>
		       		<c:forEach items="${categories}" var="c">
		       			<tr>
                    		<td><c:out value="${c.name}" /></td>
							<td>
								<ul class="m3">
		       						<c:forEach items="${c.products}" var="cPrd">
                    					<li><c:out value="${cPrd.name}"/></li>
            						</c:forEach>
								</ul>
							</td>
                    		<td><a href="/categories/${c.id}">Edit category</a></td>
		       			</tr>
		       		</c:forEach>
		    	</tbody>
			</table>
        </div>
        <nav class="navbar navbar-expand-lg justify-content-between">
  			<div class="collapse navbar-collapse">
    			<div class="navbar-nav">
      				<a class="nav-item nav-link text-start" href="/products/add">Add new product</a> 
      				<a class="nav-item nav-link text-end" href="/categories/add">Add new category</a>
      				<a class="nav-item nav-link text-end" href="/logout">Logout</a>
    			</div>
  			</div>
		</nav>
    </div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>