<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletLoginEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${linkServletLoginEmpresa}" method="post">
		E-mail: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		
		<input type="hidden" name="acao" value="Login" >
		
		<input type="submit" />
		
	</form>
</body>
</html>