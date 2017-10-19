<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="" method="post">
		<div class="form-group">
			<label for="matricula">Matrícula</label>
			<input type="number" name="funcionario.matricula" class="form-control" id="matricula" />
		</div>
		<div class="form-group">
			<label for="nome">Nome</label>
			<input type="text" name="funcionario.nome" class="form-control" id="nome" />
		</div>
		<div class="form-group">
			<label for="dataNascimento">Nome</label>
			<input type="date" name="funcionario.dataNascimento" class="form-control" id="dataNascimento" />
		</div>
		<button type="submit" class="btn btn-success">Pesquisar</button>
		<button type="reset" class="btn btn-default">Limpar</button>
	</form>
		<table class="table table-condensed table-striped">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Nome</th>
					<th>Data Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listFuncionario}" var="funcionario">
					<tr>
						<td>${funcionario.matricula }</td>
						<td>${funcionario.nome }</td>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${funcionario.dataNascimento}" />
						</td>
						<td>
							<a href="<c:url value="/funcionario/edita?matricula=${funcionario.matricula }"/>">Editar</a>
						</td>
						<td>
							<form action="/treina/funcionario/excluir/${funcionario.matricula }" method="post">
								<button type="submit" name="_method" value="DELETE">Excluir</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>