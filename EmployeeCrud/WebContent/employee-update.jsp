<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div align="center">
				<a href="https://www.javaguides.net" class="navbar-brand">
					Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"></a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
            			Edit User
            		</c:if>
						<c:if test="${emp == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${emp != null}">
					<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
					<%-- <input type="hidden" name="id1" value="<c:out value='${emp.skillid}' />" /> --%>
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${emp.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="number"
						value="<c:out value='${emp.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Salary</label> <input type="Number" step="0.01"
						value="<c:out value='${emp.salary}' />" class="form-control"
						name="salary" required="required">
				</fieldset>

				<fieldset class="form-group">'${joiningdate}'
					<label>Joining Date </label> <input type="date"
						value="<c:out value='${joiningdate}'/>" class="form-control"
						name="joiningdate" required="required"
						placeholder='${emp.joiningdate}'>

				</fieldset>
			<fieldset class="form-group">
					<label>Employee DepartmentId</label> <input type="number"
						value="<c:out value='${emp.deptid}'/>" class="form-control"
						name="deptid" required="required"
						placeholder='${emp.deptid}'>

				</fieldset>

				<fieldset class="form-group">
					<label>Skills: </label>${emp.skills[0]} <BR>
                    <c:set var="myVar" value="${fn:join(emp.skills, '')}" />
					<input type="checkbox"value="Java" name="skills"  <c:if test = "${fn:contains(myVar, 'Java')}"> checked </c:if>> Java 
				 	<input type="checkbox" value="MySql" name="skills" <c:if test = "${fn:contains (myVar,'MySql')}"> checked </c:if>> MySql <BR>

				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>