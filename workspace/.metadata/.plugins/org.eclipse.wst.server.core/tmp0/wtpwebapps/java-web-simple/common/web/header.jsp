<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.dodo.util.SecurityUtil" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#">Welcome, <%= SecurityUtil.getPrincipal().getFullName() %> </a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Logout</a></li>
				</security:authorize>
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Login</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>