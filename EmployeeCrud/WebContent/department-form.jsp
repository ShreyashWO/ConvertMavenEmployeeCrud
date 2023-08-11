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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${ dept != null}">
					<form action="updatedept" method="post">
				</c:if>
				<c:if test="${dept == null}">
					<form action="insertdept" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${dept != null}">
            			Edit Department
            		</c:if>
						<c:if test="${dept == null}">
            			Add New Department
            		</c:if>
					</h2>
				</caption>

				<c:if test="${dept != null}">
					<input type="hidden" name="deptid" value="<c:out value='${dept.deptid}' />" />
					<%-- <input type="hidden" name="id1" value="<c:out value='${emp.skillid}' />" /> --%>
				</c:if>

				<fieldset class="form-group">
					<label>Department Name</label> <input type="text"
						value="<c:out value='${dept.deptname}' />" class="form-control"
						name="deptname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Department Code</label> <input type="number"
						value="<c:out value='${dept.deptcode}' />" class="form-control"
						name="deptcode" required="required">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>