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
	<title>New Product</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-dark bg-light mt-5 p-3">
		<div class="main form-group row mt-5">
			<h3 class="text-center">Add new product</h3>
			<form:form action="/products/new" method="post" modelAttribute="product">
		    	<p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="name">Product name</form:label>
			        <form:errors class="text-danger" path="name"/>
			        <form:input type="text" class="form-control" path="name"/>
		    	</p>  
		   		 <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="description">Product description</form:label>
			        <form:errors class="text-danger" path="description"/>
			        <form:input type="textarea" class="form-control" path="description"/>
			    </p> 
			   	<p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="price">Product price</form:label>
			        <form:errors class="text-danger" path="price"/>
			        <form:input min=".01" class="form-control" path="price"/>
			    </p>
				<input type="submit" value="Create" class="m-3"/>
			</form:form>
		</div>
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