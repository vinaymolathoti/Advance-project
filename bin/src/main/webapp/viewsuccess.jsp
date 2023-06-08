<%@page import="com.sathya.register.UserData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
table{
margin: auto;
text-align: center;
}
.bg{
	background:url(indexbg.jpg);
	background-repeat: no-repeat;
	background-size: 40cm 20cm;
}
.container{
  width: 100%;
  background:linear-gradient(to top,rgba(0,0,0,0.5)50%,rgba(0,0,0,0.5)50%);
    background-position: center;
    background-size: cover;
    height: 109vh;
    color: white;
    text-align: center;
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
    margin-top:20px;
  }
</style>
</head>
<body class="bg">
<div class="container">
<h1>List of Users</h1>
<table border="1">
<tr>
<th>userId</th>
<th>User Name</th>
<th>Email</th>
<th>Country</th>
<th>Qualification</th>
<th>technologies</th>
<th>Gender</th>
<th>Address</th>
<th colspan="2">Action</th>
</tr>
<%   List<UserData>users= (List<UserData>) request.getAttribute("users");%>
<c:forEach  items="${users}"  var="user" >
<tr>
<form method="post" action="EditOrDeleteServlet">
<td><input type="hidden" name="userid" value="${user.userId}">${user.userId }</td>
<td><input type="text"  name="username" value="${user.username}"></td>
<td><input type="email" name="email"    value="${user.email}"></td>
<td><input type="text"  name="country"  value="${user.country}"></td>
<td><input type="text"  name="qualification" value="${user.qualification}"></td>
<td><input type="text"  name="technologies"   value="${user.technologies}"></td>
<td><input type="text"  name="gender"   value="${user.gender}"></td>
<td><input type="text"  name="address"  value="${user.address}"></td>
<td><input type="submit" name="action"  value="Edit"></td>
<td><input type="submit" name="action"  value="Delete"></td>
 </form>
</tr>
</c:forEach>
</table>
<a href="index.html" class="fa fa-home icon"> Home </a>
</div>
</body>
</html>