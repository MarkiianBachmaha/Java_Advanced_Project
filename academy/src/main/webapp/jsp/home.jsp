<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>

<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item"><spring:message code="menu.menu"/></h3>
			<a href="/home" class="w3-bar-item w3-button"><spring:message code="menu.home"/></a>
			<a href="/show-entrants" class="w3-bar-item w3-button"><spring:message code="menu.entrants"/></a>
			
			<security:authorize access="hasRole('ADMINISTRATOR')">
        	<a href="/admin_panel" class="w3-bar-item w3-button"><spring:message code="menu.adminpanel"/></a>
        	</security:authorize>
        	<a href="/login?logout" class="w3-bar-item w3-button"><spring:message code="menu.logout"/></a>
		</div>

<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1><spring:message code="home.title"/></h1>
			</div>

			<div class="w3-container">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
				
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>

					<h2>
						Welcome ${pageContext.request.userPrincipal.name} |
						<a onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>

				</c:if>

				<div class="w3-container" style="display: flex; flex-wrap: wrap">
					<c:if test="${not empty faculties}">
						<c:forEach items="${faculties}" var="currentFaculty">

							<div class="w3-card-4" style="width: 20%; margin: 2%">
								<img src="https://kaverisias.com/wp-content/uploads/2018/01/catalog-default-img.gif"
									alt="Logo" style="width: 100%">
								<div class="w3-container w3-center">
									<h3>${currentFaculty.name}</h3>
									<p><spring:message code="home.number_students"/>: ${currentFaculty.numberOfStudents}</p>
									<p><spring:message code="home.necessary_subjects"/>: ${currentFaculty.subjects}</p>
								</div>
								<security:authorize access="hasRole('USER')">
								<a class="w3-button w3-block w3-dark-grey"
									href="${contextPath}/registration-at-faculty?facultyId=${currentFaculty.id}&email=${pageContext.request.userPrincipal.name}">
									<spring:message code="home.register"/></a>
								</security:authorize>

							</div>

						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>

	</div>
	<!-- /container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>