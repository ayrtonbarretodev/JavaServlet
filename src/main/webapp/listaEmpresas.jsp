<%@page import="br.com.ayrton.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
	<c:if test="${not empty empresa}">
	Empresa ${empresa} cadastrada com sucesso!
	</c:if> <br />
	
	Lista de empresas <br />
	
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li>
			${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a> 
			</li>
		</c:forEach>
		
	</ul>
	
</body>
</html>