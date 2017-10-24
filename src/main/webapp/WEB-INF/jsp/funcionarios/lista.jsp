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
<title>Home</title>
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<div class="container">
		<form action="<c:url value='/funcionarios/pesquisa'/>" method="post">
			<div class="form-group">
				<label for="matricula">Matrícula</label>
				<input type="number" id="matricula" name="funcionario.matricula" placeholder="Digite a Matrcula" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="nome">Nome</label>
				<input type="text" id="nome" name="funcionario.nome" placeholder="Digite o Nome do Funcionário" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="dataNascimento">Data de Nasciomento</label>
				<input type="text" id="dataNascimento" name="funcionario.dataNascimento" placeholder="Digite a Data de Nascimento" class="form-control"/>
			</div>
			<button type="submit">Pesquisar</button>
			<button type="reset">Limpar</button>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Nome</th>
					<th>Data Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${funcionarios}" var="funcionario">
					<tr>
						<td>${funcionario.matricula}</td>
						<td>${funcionario.nome}</td>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${funcionario.dataNascimento}" />
						</td>
						<td>
							<a href="<c:url value="/funcionarios/busca?matricula=${funcionario.matricula}"/>" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-edit"></span>
								Editar
							</a>
						</td>
						<td>
							<form action="<c:url value="/funcionarios/deleta/${funcionario.matricula}"/>" method="post">
								<button type="submit" name="_method" value="DELETE" class="btn btn-default btn-sm" onclick="return confirm('Você tem certeza que quer deletar?')">
									<span class="glyphicon glyphicon-remove"></span>
									Deletar
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>