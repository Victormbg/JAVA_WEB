<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.livraria.controller.CategoriaController" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cont" 
				class="br.com.livraria.controller.CategoriaController">
				
	<table border="3">	
		<tr> 
			<td>Código</td>
			<td>Descrições</td>
			<td>Ações</td>
			
			
		</tr>			
	<c:forEach items="${cont.listarCategoria() }"
			   var="_cat">
			   
		<tr>
			<td> ${_cat.codigo } </td>
			<td> ${_cat.descricao }</td>
	
		    <td><a href="Categoria_pr?id=${_cat.id}&acao=buscar">Alterar</a> /
		    <a href="Categoria_pr?id=${_cat.id }&acao=excluir">Excluir</a>
		    </td>
		</tr>
	</c:forEach>			
	</table>			
	</jsp:useBean>
	<a href="Categoria_pr?acao=inicioInclusao">Incluir Categoria</a>
</body>
</html>