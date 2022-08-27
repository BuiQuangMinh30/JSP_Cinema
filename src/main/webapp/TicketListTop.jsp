<%@page import="com.fpt.edu.entity.TicketDashBoadTop"%>
<%@page import="com.fpt.edu.entity.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
  <tr>
    <th>Name</th>
    <th>Num</th>
  </tr>

  <%
  List<TicketDashBoadTop> boadTopMovies = null;
  if(request.getAttribute("topMovies") !=null){
	  boadTopMovies = (List<TicketDashBoadTop>) request.getAttribute("topMovies");  
  }
  if(request.getAttribute("topShowTimes") !=null){
	  boadTopMovies = (List<TicketDashBoadTop>) request.getAttribute("topShowTimes");  
  }
  %>
  <%
  for(TicketDashBoadTop item: boadTopMovies){
  %>
		<tr>
	    <td><%=item.getName()%></td>
	    <td><%=item.getNum() %></td>
	  </tr>
	<%
		}
	%>
</table>
</body>
</html>