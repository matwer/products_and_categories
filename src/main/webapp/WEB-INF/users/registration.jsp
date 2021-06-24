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
	<title>Register</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
    <div class="container border border-dark bg-light mt-5 p-3">
	    <h2 class="text-center">Register</h2>
    	<div class="main form-group row mt-5">
		    <p><form:errors class="text-danger text-center" path="user.*"/></p>
		    <!-- this is the default landing page -->
		    <form:form method="POST" action="/registration" modelAttribute="user">
		    	<p class="m-3">
		            <form:label  class="col-sm-2 col-form-label" path="first_name">First name</form:label>
		            <form:input class="form-control" type="text" path="first_name" placeholder="must be at least 5 characters"/>
		        </p>
		        <p class="m-3">
		            <form:label  class="col-sm-2 col-form-label" path="last_name">Last name</form:label>
		            <form:input class="form-control" type="text" path="last_name" placeholder="must be at least 5 characters"/>
		        </p>
		        <p class="m-3">
		            <form:label  class="col-sm-2 col-form-label" path="email">Email</form:label>
		            <form:input class="form-control" type="email" path="email"/>
		        </p>
		        <p class="m-3">
		            <form:label  class="col-sm-2 col-form-label" path="password">Password</form:label>
		            <form:password class="form-control" path="password" placeholder="must be at least 8 characters"/>
		        </p>
		        <p class="m-3">
		            <form:label  class="col-sm-2 col-form-label" path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password class="form-control" path="passwordConfirmation"/>
		        </p>
		        <input type="submit" value="Register" class="m-3"/>
		    </form:form>
		   	<!-- redirect registered users to login page -->
			<p class="m-3">Already registered? Click <a href="/login">here</a> to login</p>
		</div>
    </div>	
</body>
</html>
