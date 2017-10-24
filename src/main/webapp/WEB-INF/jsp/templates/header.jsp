<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value='/funcionarios'/>">Funcion�rios</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="<c:url value='/funcionarios'/>">Home</a>
			</li>
			<li>
				<a href="<c:url value='/funcionarios/cadastro'/>">Cadastro</a>
			</li>
		</ul>
	</div>
</nav>
