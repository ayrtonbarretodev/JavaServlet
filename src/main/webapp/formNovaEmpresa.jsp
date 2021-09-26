<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post"> <!-- O action está "chamando" o servlet NovaEmpresaServlet -->
		Nome: <input type="text" name="nome">
		<input type="submit" />
	</form>
</body>
</html>