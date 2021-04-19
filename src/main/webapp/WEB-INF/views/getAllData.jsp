<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
     <%@page import="com.te.springmvcemployee.bean.EmployeeBean" %>
    
    
     <%List<EmployeeBean> empbean=(List<EmployeeBean>)request.getAttribute("msg"); %>
     <%String err=(String)request.getAttribute("errmsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%if(err !=null && !err.isEmpty()){ %>

<h1 style="color: blue"><%=err %></h1>

<%} %>

<%for(EmployeeBean bean:empbean){ %>
<h4>Name:<%bean.getName(); %></h4>
<h4>Id:<%bean.getId(); %></h4>
<h4>Date of birth:<%bean.getBirthDate();%></h4>
<%} %>
</body>
</html>