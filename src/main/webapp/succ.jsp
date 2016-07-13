<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Movieflix</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style2.css">
</head>

<body>
 <div id="mainContainer" class="container-fluid">
  <nav id="navbar" class="navbar-fixed-top">
   <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="#"><img src="css/logo.jpg" height="40px"></a>
    </div>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       <li class="dropdown">
        <a href="#" id="nav-browse-btn" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Browse <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <div class="arrow-up arrow-up-align-left"></div>
           <li><a href="#">Home</a></li>
           <li><a href="#">My Lists</a></li>
           <li role="separator" class="divider"></li>
           <li><a href="#">New Arrivals</a></li>
           <li role="separator" class="divider"></li>
           <li><a href="#">Top Hits</a></li>
          </ul>
         </li>
           <li><a href="#">Movies</a></li>
           <li><a href="#">Series</a></li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <img id="profile-pic" src="css/dp.jpg"> Vajrender <span class="caret"></span>
                </a>
               <ul class="dropdown-menu">
                  <div class="arrow-up arrow-up-align-right"></div>
                    <li><a href="#">Vajrender</a></li>
                    <li><a href="#">Manage Profile</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">My Account</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="index.jsp">Sign Out</a></li>
                 </ul>
               </li>
             </ul> 
                <div class="navbar-form navbar-right" role="search">
                <div id="nav-search-div" class="form-group">
                  <span class="glyphicon glyphicon-search"></span>
                    <input id="nav-search" type="text" class="form-control" placeholder="Search">
                </div>
               </div>
             </div><!-- /.navbar-collapse -->
          </div>
        </nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/index.js"></script>
 </body>
</html>