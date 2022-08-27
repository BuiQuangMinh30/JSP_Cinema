<%@page import="java.util.List"%>
<%@page import="com.fpt.edu.entity.TypeMovie"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section class="container">
<center><h1>Create Movie</h1></center>
<form method="POST" action="MovieCreate">
  <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Year</label>
    <input name="year" type="text" class="form-control" id="exampleInputPassword1" >
  </div>
 
	 <div class="form-group">
    <select name="idTypeMovie" id="typeMovies">		
     <%
						List<TypeMovie> typeMovies = (List<TypeMovie>) request.getAttribute("typeMovies");
					%>	
      <%
						for(TypeMovie item: typeMovies){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Chi tiết</label>
    <input name="description" type="text" class="form-control" id="exampleInputPassword1" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Start Time</label>
    <input name="startTime" type="datetime-local" class="form-control" id="exampleInputPassword1" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">End Time</label>
    <input name="endTime" type="datetime-local" class="form-control" id="exampleInputPassword1" >
  </div>
  <p align="left">
						<input type="submit" value="Submit"> 
						<input type="reset" value="Reset">
					</p>
</form>

	</section>
</body>
</html>