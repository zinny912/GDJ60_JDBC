<%@page import="com.iu.main.locations.LocationDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Locations List Page</h1>
	<%
	
	ArrayList<LocationDTO> ar = (ArrayList)request.getAttribute("list");
	%>
	
	<div>
	
	<h3><%= ar.get(0).getCity() %></h3>
	<h3><%= ar.get(1).getCity() %></h3>
	<h3><%= ar.get(2).getCity() %></h3>
	<h3><%= ar.get(3).getCity() %></h3>
	<h3><%= ar.get(4).getCity() %></h3>
	<h3><%= ar.get(5).getCity() %></h3>
	<h3><%= ar.get(6).getCity() %></h3>
	<h3><%= ar.get(7).getCity() %></h3>
	<h3><%= ar.get(8).getCity() %></h3>
	<h3><%= ar.get(9).getCity() %></h3>
	<h3><%= ar.get(10).getCity() %></h3>
	
	
</div>
	
	

</body>
</html>