<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand">
					Employee Management App </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listdept"
					class="nav-link"></a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Department</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/newdept" class="btn btn-success">Add
					New department</a><br />
			</div>

			<br>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>DeptCode</th>
						<th>Actions</th>
					</tr>
				<tbody>

					<c:forEach var="dept" items="${listdept}">
						<tr>
							<td><c:out value="${dept.deptname}" /></td>
							<td><c:out value="${dept.deptcode}" /></td>
						 <td><a href="deptedit?deptid=<c:out value='${dept.deptid}' />">Edit</a>
							 <a href="deptdelete?deptid=<c:out value='${dept.deptid}' />">Delete</a> </td> 
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
		<div class="container text-center">
		<a href="<%=request.getContextPath()%>/employee" class="btn btn-success">
			Go to Employee management</a><br />
	</div>
</body>
</html>