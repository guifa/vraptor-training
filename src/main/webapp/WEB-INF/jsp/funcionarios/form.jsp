<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Funcionário</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty funcionario.matricula}">
			<form action="<c:url value='/funcionarios/adicionar'/>" method="post">
		</c:when>
		<c:otherwise>
			<form action="<c:url value='/funcionarios/atualizar'/>" method="post">
		</c:otherwise>
	</c:choose>
	<c:forEach items="${errors}" var="error">
    		${error.message}<br />
	</c:forEach>
	<div>
		<label for="matricula">Matrícula</label>
		<input type="number" id="matricula" name="funcionario.matricula" value="${funcionario.matricula}" />
	</div>
	<div>
		<label for="nome">Nome</label>
		<input type="text" id="nome" name="funcionario.nome" value="${funcionario.nome}" />
	</div>
	<div>
		<label for="dataNascimento">Data de Nascimento</label>
		<input type="text" id="dataNascimento" name="funcionario.dataNascimento" value="<fmt:formatDate pattern='dd/MM/yyyy' value='${funcionario.dataNascimento}' />" />
	</div>
	<c:choose>
		<c:when test="${empty funcionario.matricula}">
			<input type="submit" value="Salvar" />
		</c:when>
		<c:otherwise>
			<button type="submit" name="_method" value="PUT">Atualizar</button>
		</c:otherwise>
	</c:choose>
	</form>

</body>
</html>