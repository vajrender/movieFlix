<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>User-Login</title>
  <link rel="stylesheet" href="css/style1.css">
  <script type="text/javascript" src="js/login.js"> </script>
</head>

<body>
 <marquee><img src ="css/logo2.png"/></marquee>
  <section class="container">
    <div class="login">
      <h1>Login</h1>
      <form name="f2" id="submitForm" method="GET" action = "api/users/signin">
        <p><input type="text" name="email" value="" placeholder="Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p> <a href="#">Forgot password ? </a></p>
        <p class="remember_me">
          
        </p>
        <p class="submit"><input type="submit" value="Login"> </p>
		
      </form>
    </div>

    <div class="login-help">
      <p> <h2> New User? </h2> <a href="registration.jsp">
        <input type="submit" value="Sign-up"></a></p>
    </div>
  </section>
 </body>
</html>