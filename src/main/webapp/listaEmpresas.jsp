<%@page import="br.com.ayrton.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
	Lista de empresas <br />
	<ul>
	<% 
		List<Empresa> listaEmpresas = (List <Empresa>)request.getAttribute("listaEmpresas");
		for(Empresa empresa: listaEmpresas){
	%>
		<li><%= empresa.getNome() %></li>
	<% 
		}
	%>	
	</ul>
	
</body>
</html>