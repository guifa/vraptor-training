<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Funcionário</title>
</head>
<body>

	<form action="<c:url value='/funcionarios/adiciona'/>" method="post">

		Matricula:
		<input type="text" name="funcionario.matrciula" />
		<br />
		Nome:
		<input type="text" name="funcionario.nome" />
		<br />
		Data de Nascimento:
		<input type="text" name="funcionario.dataNascimento" />
		<br />
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>