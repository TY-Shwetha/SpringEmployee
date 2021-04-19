<%@page import="com.te.springmvcemployee.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String msg=(String)request.getAttribute("errmsg"); %>
    <%EmployeeBean bean=(EmployeeBean)request.getAttribute("data"); %>
     <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%if(msg !=null && !msg.isEmpty()){ %>

<h1 style="color: blue"><%=msg %></h1>

<%} %>

<%if(bean !=null){ %>
<h4>Name :<%=bean.getName() %></h4>
<h4>Id :<%=bean.getId() %></h4>
<h4>Date of Birth :<%=bean.getBirthDate() %></h4>
<%} %>
	<fieldset>
		<legend>SearchForm</legend>
		<form action="./search1">
			<table>
				<tr>
					<td>Enter EmployeeId</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>
			
				<tr>
					<td><input type="submit" value="SEARCH"></td>
				</tr>
			</table>
		</form>
	</fieldset>


</body>
</html>