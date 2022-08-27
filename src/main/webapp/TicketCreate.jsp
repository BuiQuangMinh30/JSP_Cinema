<%@page import="com.fpt.edu.entity.ShowTime"%>
<%@page import="com.fpt.edu.entity.Movie"%>
<%@page import="com.fpt.edu.entity.Room"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.edu.entity.TypeMovie"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section class="container">
<center><h1>Create Ticket</h1></center>
<form method="POST" action="TicketCreate">
  <div class="form-group">
    <label for="exampleInputEmail1">Rooms</label>
    <%
						List<Room> rooms = (List<Room>) request.getAttribute("rooms");
					%>
					<select name="idRoom" id="idRoom">					
					<%
						for(Room item: rooms){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Movies</label>
    <%
						List<Movie> movies = (List<Movie>) request.getAttribute("movies");
					%>
					<select name="idMovie" id="idMovie">					
					<%
						for(Movie item: movies){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
  </div>

	 <div class="form-group">
    <label for="exampleFormControlSelect1">Show time</label>
    <%
						List<ShowTime> showtimes = (List<ShowTime>) request.getAttribute("showtimes");
					%>
					<select name="idShowTime" id="idShowTime">					
					<%
						for(ShowTime item: showtimes){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Price: </label>
    <input type="number" name="price" size="12">
  </div>

	<p align="left">
		<input type="submit" value="Submit"> 
		<input type="reset" value="Reset">
	</p>
</form>

	</section>

</body>
</html>