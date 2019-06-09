<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.livraria.controller.AutorController" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livraria</title>
</head>
<body>
<jsp:useBean id="cont" 
				class="br.com.livraria.controller.AutorController">
				
	<table border="3">	
		<tr> 
			<td>Nome</td>
			<td>Nacionalidade</td>
			<td>Ações</td>
			
			
		</tr>			
	<c:forEach items="${cont.listarAutor() }"
			   var="_aut">
			   
		<tr>
			<td> ${_aut.nome } </td>
			<td> ${_aut.nacionalidade }</td>
	
		    <td><a href="Autor_pr?id=${_aut.id}&acao=buscar">Alterar</a> /
		    <a href="Autor_pr?id=${_aut.id }&acao=excluir">Excluir</a>
		    </td>
		</tr>
	</c:forEach>			
	</table>			
	</jsp:useBean>
	<a href="Autor_pr?acao=inicioInclusao">Incluir Autor</a>
</body>
</html>