<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="br.com.boletim.controller.AlunoController" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="cont" 
				class="br.com.boletim.controller.AlunoController">
				
	<table border="3">	
		<tr> 
			<td>Nome</td>
			<td>Matrícula</td>
			<td>Média</td>
			<td>Situação</td>
			<td>Ações</td>
			
			
		</tr>			
	<c:forEach items="${cont.listarAlunos() }"
			   var="_alu">
	   <c:set var="media" 
	   value="${(_alu.nota1+_alu.nota2+_alu.nota3) /3 }"></c:set>
		<tr>
			<td> ${_alu.nome } </td>
			<td> ${_alu.matricula }</td>
			<td> <fmt:formatNumber pattern="##0.00" value="${media }"/> </td>
			<td>
		<c:if test="media">Aprovado se a média >=6  Reprovado se a média < 6</c:if>
			</td>
		    <td><a href="Boletim?id=${_alu.id}&acao=buscar">Alterar</a> /
		    <a href="Boletim?id=${_alu.id }&acao=excluir">Excluir</a>
		    </td>
		</tr>
	</c:forEach>			
	</table>			
	</jsp:useBean>
	<a href="Boletim?acao=inicioInclusao">Incluir Aluno</a>
</body>
</html>