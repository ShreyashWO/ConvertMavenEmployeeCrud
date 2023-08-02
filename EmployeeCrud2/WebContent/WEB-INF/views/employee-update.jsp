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

				<fieldset class="form-group">
					<label>Joining Date </label> <input type="date"
						value="<c:out value='${joiningdate}'/>" class="form-control"
						name="joiningdate" required="required"
						placeholder='${emp.joiningdate}'>

				</fieldset>



				<fieldset class="form-group">
					<label>Skills: </label>${emp.skills[0]} <BR>
					<c:set var="skill_java" value='${emp.skills[0]}' />
					<c:set var="java_check" value="Java,"  />
					<c:set var="java_check2" value="Java"  />
					<c:set var="skill_mysql" value='${emp.skills[1]}' />
					<c:set var="mysql_check" value="MySql"/>
					<%-- <c:choose>

						<c:when test = "${{emp.skills[0]} eq Java,}" &&  "${{emp.skills[1]} eq 'MySql'}">
				            Java  : <input type="checkbox" value="<c:out value='${emp.skills[0]}' />" checked name="skill" >
         					Mysql  : <input type="checkbox" value="<c:out value='${emp.skills[1]}' />" checked  name="skill" >
				         </c:when>
                          
                          <c:if test = "${{emp.skills[0]} eq 'Java,'}"> 
                                Java  : <input type="checkbox"
								value="<c:out value='${emp.skills[0]}' />" checked name="skills"> </c:if>
                       <c:if test = "${{emp.skills[1]} eq 'MySql'}"> 
                       	Mysql  : <input type="checkbox"
								value="<c:out value='${emp.skills[1]}' />" checked name="skills"> </c:if>
                           
                        <c:when test="${skill_java eq java_check && skill_mysql eq skill_mysql}">
				            Java  : <input type="checkbox"
								value="<c:out value='${emp.skills[0]}' />" checked name="skills">
         					Mysql  : <input type="checkbox"
								value="<c:out value='${emp.skills[1]}' />" checked name="skills">

						</c:when>
						<c:when test="${skill_java == java_check2}">
				            Java  : <input type="checkbox"
								value="<c:out value='${emp.skills[0]}' />" checked name="skills">
         					Mysql  : <input type="checkbox"
								value="<c:out value='${emp.skills[1]}' />"  name="skills">

						</c:when>
                        <c:when test="${skill_mysql == mysql_check}">
				            Java  : <input type="checkbox"
								value="<c:out value='${emp.skills[0]}' />"  name="skills">
         					Mysql  : <input type="checkbox"
								value="<c:out value='${emp.skills[1]}' />"  checked name="skills">

						</c:when>
                        
						<c:otherwise>
				            Java  : <input type="checkbox"
								value="<c:out value='${emp.skills}' />"  name="skill">
         					MySql  : <input type="checkbox"
								value="<c:out value='${emp.skills}' />" name="skill">
						</c:otherwise>
					</c:choose> --%>

                    <c:set var="myVar" value="${fn:join(emp.skills, '')}" />
					<input type="checkbox"value="Java" name="skills"  <c:if test = "${fn:contains(myVar, 'Java')}"> checked </c:if>> Java 
				 	<input type="checkbox" value="MySql" name="skills" <c:if test = "${fn:contains (myVar,'MySql')}"> checked </c:if>> MySql <BR>
					 
					 
					<!-- <input type="checkbox"value="Java" name="skills" checked > Java 
					 <input type="checkbox" value="MySql" name="skills" checked > MySql <BR> -->

				</fieldset>



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>