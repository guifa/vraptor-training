<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Cadastro de Funcionário</title>
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${empty funcionario.matricula}">
				<form action="<c:url value='/funcionarios/adicionar'/>" method="post">
			</c:when>
			<c:otherwise>
				<form action="<c:url value='/funcionarios/atualizar'/>" method="post">
			</c:otherwise>
		</c:choose>
		<c:forEach items="${errors}" var="error">
			<div class="alert alert-danger">
				<strong>Erro!</strong>
				${error.message}
			</div>
		</c:forEach>
		<div class="form-group">
			<label for="matricula">Matrícula</label>
			<input type="number" id="matricula" name="funcionario.matricula" placeholder="Digite a Matrícula" class="form-control"  value="${funcionario.matricula}" />
		</div>
		<div class="form-group">
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="funcionario.nome" placeholder="Digite o Nome do Funcionário" class="form-control" value="${funcionario.nome}" />
		</div>
		<div class="form-group">
			<label for="dataNascimento">Data de Nascimento</label>
			<input type="text" id="dataNascimento" name="funcionario.dataNascimento" placeholder="Digite a Data de Nascimento" class="form-control" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${funcionario.dataNascimento}' />" />
		</div>
		<c:choose>
			<c:when test="${empty funcionario.matricula}">
				<input type="submit" value="Salvar" class="btn btn-default"/>
			</c:when>
			<c:otherwise>
				<button type="submit" name="_method" value="PUT" class="btn btn-default">Atualizar</button>
			</c:otherwise>
		</c:choose>
		</form>
	</div>

	<c:import url="../templates/footer.jsp" />
</body>
</html>