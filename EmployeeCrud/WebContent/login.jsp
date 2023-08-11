<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Admin Login Form</h1>
		<form action="<%=request.getContextPath()%>/checkauth" method="post">
			<table style="with: 100%">

				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>

                <tr>
					<td>Capcha</td>
					<td><input type="text" name="capta" /></td>
				</tr>

			</table>
		<input type="submit" value="Submit" />
		
		<c:if test="${msg != null}">
			<fieldset >
				<label> msg </label>  
				<h1 name = "msg">'${msg}'</h1>
				
				
			</fieldset>
		</c:if>
	</div>
</body>
</html>