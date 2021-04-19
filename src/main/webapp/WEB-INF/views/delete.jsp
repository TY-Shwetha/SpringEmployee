<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
    <%String err=(String)request.getAttribute("errmsg"); %>
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

<%if(err !=null && !err.isEmpty()){ %>

<h1 style="color: blue"><%=err %></h1>

<%} %>

	<fieldset>
		<legend>Delete</legend>
		<form action="./delete">
			<table>
				<tr>
					<td>Enter EmployeeId to be deleted</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>				
				<tr>
					<td><input type="submit" value="DELETE"></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>