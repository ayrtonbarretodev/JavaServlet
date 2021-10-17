<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServletAlteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<form action="${linkServletAlteraEmpresa}" method="post"> <!-- O action está "chamando" o servlet NovaEmpresaServlet -->
		Nome: <input type="text" name="nome" value="${buscaEmpresa.nome}">
		Data de Abertura: <input type="text" name="data" value="<fmt:formatDate value="${buscaEmpresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${buscaEmpresa.id }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="submit" />
	</form>
</body>
</html>