<%@page import="com.fpt.edu.entity.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<div>
<a href="TicketDashBoadTopMovie">Thống kê top phim theo ngày</a>
<a href="TicketDashBoadTopShowTime">Thống kê top khung giờ</a></div>
<table class="table">
 <thead>
    <tr>
      <th>Id</th>
    <th>idMovieDetail</th>
    <th>idShowTime</th>
    <th>price</th>
    <th>status</th>
    <th>createdAt</th>
    </tr>
  </thead>
 <tbody>
  <%
	List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
  %>
  <%
		for(Ticket item: tickets){
	%>
		<tr>
	    <td><%=item.getId()%></td>
	    <td><%=item.getIdMovieDetail() %></td>
	    <td><%=item.getIdShowTime() %></td>
	    <td><%=item.getPrice() %></td>
	    <td><%=item.getStatus() %></td>
	    <td><%=item.getCreatedAt() %></td>
	    <td><a href="TicketBuy?id=<%=item.getId() %>">Buy</a></td>
	  </tr>
	<%
		}
	%>
	</tbody>
</table>
</body>
</html>