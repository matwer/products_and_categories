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
	<title>Login</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
    <div class="container border border-dark bg-light mt-5 p-3">
	    <h2 class="text-center">Login</h2>
    	<div class="main form-group row mt-5">
		    <p class="text-danger text-center"><c:out value="${error}" /></p>
		    <form method="post" action="/login">
		        <p class="m-3">
		            <label class="col-sm-2 col-form-label" for="email">Email</label>
		            <input class="form-control" type="email" id="email" name="email"/>
		        </p>
		        <p class="m-3">
		            <label class="col-sm-2 col-form-label" for="password">Password</label>
		            <input class="form-control" type="password" id="password" name="password"/>
		        </p>
		        <input type="submit" value="Login" class="m-3"/>
		    </form>
		    <!-- redirect new users to registration page --> 
		    <p class="m-3">New user? Click <a href="/register">here</a> to register</p>
	    </div>
    </div>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>  
</body>
</html>
