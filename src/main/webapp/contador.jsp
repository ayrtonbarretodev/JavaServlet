<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contar de 2 em 2</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i} <br />
	</c:forEach>
</body>
</html>