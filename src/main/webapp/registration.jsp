<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MovieFlix</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>

<script src="js/registration.js"></script>


</head>
<body>

<div class = "container">
<form action="api/users/signup" method="post" id="submitForm">    
<center>
<table>

	     <div class="header">
        
            <h1>Sign Up</h1>
            
            
        </div>
        <div class ="sep" ></div>
        <div class="inputs">

	                <tr> <td><h3><label for=name>First Name</label></h3></td>
	                <td><input type="text" name = "firstName" placeholder = "First Name" /></td></tr>

                    <tr><td><h3><label for=name>Last Name</label></h3></td>
                	<td><input type="text" name = "lastName" placeholder = "Last Name"/></td></tr>

	                <tr><td><h3><label for=email>Email</label></h3></td>
	                <td><input type="email" name = "email" placeholder = "e-mail"/> </td></tr>

	                <tr><td><h3><label for=password>Password</label></h3></td>
	                <td><input type="password" name = "password" placeholder = "password" /></td></tr>
     				
	          <tr><td><input type="hidden" value="user" name="role" /></td></tr>
	          <tr><td><input id="submitId" type="submit" value="Submit"></td>
	          <td><h3> <a href="index.jsp">Click here to sign-in </a></h3></td></tr>
	          
	          <label id="message" class="msg">This Email already exists.</label>

	          
	    </div>		
		</table> 
		</center>
	</form> 
	
</div>		
       
</body>
</html>