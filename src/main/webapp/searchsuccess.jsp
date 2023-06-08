<%@page import="com.sathya.register.UserData"%>
<%@ page language="java" contentType="text/html;"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.bg{
    color:white;
	background:url(indexbg.jpg);
	background-repeat: no-repeat;
	background-size: 40cm 20cm;
}
.trbg{
background: black;
margin-top: 50px;
}
.navbar{
text-align: center;
color: white;
margin-top: 20px;
}
.icon {
    padding: 7px;
    background: blue;
    color: white;
    min-width: 5px;
    max-height: 15px;
    margin: 1.5px;
    border: 2px solid black;
    border-radius:4px; 
  }
</style>
</head>
<body class="bg">
<% UserData user=(UserData)request.getAttribute("user"); %>
<table align="center" border="2px" class="trbg">
<tr>
<td>userId</td>
<td>${user.userId}</td>
</tr>
<tr><td>username</td>
<td>${user.username}</td>
</tr>
<tr>
<td>email</td>
<td>${user.email}</td>
</tr>
<tr>
<td>country</td>
<td>${user.country}</td>
</tr>
<tr>
<td>qualification</td>
<td>${user.qualification}</td>
</tr>
<tr>
<td>gender</td>
<td>${user.gender}</td>
</tr>
<tr>
<td>technologies</td>
<td>${user.technologies}</td>
</tr>
<tr>
<td>address</td>
<td>${user.address}</td>
</tr>
<tr>
<td>comments</td>
<td>${user.comments}</td>
</tr>
</table>
<div class="navbar">
<a href="search.html" class="fa fa-arrow-circle-left icon"></a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.html" class="fa fa-home icon"></a>
</div>>
</body>
</html>