<%@page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html">
<title>GadgetDeal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

</head>


<body>

<div>
<marquee  direction="left" >
<b>Welcome to GadgetDeal Sale.10% CashBack on every Order and Many More.Shop Today!!</b></marquee>
<br>
</div>


<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/home"/>">GadgetDeal</a></div>
      
  <c:if test="${!sessionScope.loggedIn}">
    <ul class="nav navbar-nav"> 
      <li><a href="<c:url value="/registerSeller"/>">Sell</a></li>
      <li><a href="<c:url value="/creditsHomePage"/>">Credits</a></li>  
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     </ul>
  </c:if>
    
 <c:if test="${sessionScope.loggedIn}">
   
 <c:if test="${sessionScope.role=='ROLE_ADMIN'}" >
   <ul class="nav navbar-nav">
      <li><a href="<c:url value="/category"/>">Manage Category</a></li>
      <li><a href="<c:url value="/product"/>">Manage Product</a></li>
      <li><a href="<c:url value="/supplier"/>">Manage Supplier</a></li> 
   </ul>
   
   <ul class="nav navbar-nav navbar-right">
   <li>
      <c:if test="${sessionScope.loggedIn}">
      <font color="white">Hello ${sessionScope.username}
      <a href="<c:url value="/perform_logout" />"> Logout</a></font> 
      </c:if>
      </li>
   </ul>
 </c:if>
   
 <c:if test="${sessionScope.role=='ROLE_USER'}" >
   <ul class="nav navbar-nav">       
      <li><a href="<c:url value="/registerSeller"/>">Sell</a></li>
      <li><a href="<c:url value="/MyCredits"/>">Credits</a></li>  
      <li><a href="<c:url value="/CustomerService"/>">Customer Service</a></li>      
   </ul>
   
   <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/productsDisplay"/>">Products</a></li>  
      <li><a href="<c:url value="/Cart"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Cart (${sessionScope.cartsize})</a></li>     
      <li>
      <c:if test="${sessionScope.loggedIn}">
      <font color="white">Hello ${sessionScope.username}
      <a href="<c:url value="/perform_logout" />"> Logout</a></font> 
      </c:if>
      </li>
   </ul>
 </c:if>
    
</c:if>    
</div>
</nav>



