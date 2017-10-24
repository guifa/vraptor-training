<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value='/funcionarios/pesquisa'/>" method="post">
		<div>
			<label for="matricula">Matrícula</label>
			<input type="number" id="matricula" name="funcionario.matricula" />
		</div>
		<div>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="funcionario.nome" />
		</div>
		<div>
			<label for="dataNascimento">Data de Nasciomento</label>
			<input type="text" id="dataNascimento" name="funcionario.dataNascimento" />
		</div>
		<button type="submit">Pesquisar</button>
		<button type="reset">Limpar</button>
	</form>
	<table>
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
						<a href="<c:url value="/funcionarios/busca?matricula=${funcionario.matricula}"/>">Editar</a>
					</td>
					<td>
						<form action="/treina/funcionarios/deleta/${funcionario.matricula}" method="post">
							<button type="submit" name="_method" value="DELETE" onclick="return confirm('Você tem certeza que quer deletar?')">Deletar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>