<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.boletim.controller.AlunoController" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Aluno</title>
</head>
<body>
<form name="formI" method="post" action="Boletim" >
<input type="hidden" name="acao" 
 value="${requestScope['acao'] }"/>
<input type="hidden" name="id"
 value="${requestScope ['aluno'].getId() }"/>
Nome:
<input type="text" name="txtNome"
value="${requestScope['aluno'].getNome() }"/><br>
Matrícula:
<input type="text" name="txtMatricula"
value="${requestScope['aluno'].getMatricula() }"/><br>
Nota 1:
<input type="text" name="txtNota1"
value="${requestScope['aluno'].getNota1() }"/><br>
Nota 2:
<input type="text" name="txtNota2"
value="${requestScope['aluno'].getNota2() }"/><br>
Nota 3:
<input type="text" name="txtNota3"
value="${requestScope['aluno'].getNota3() }"/><br>

<input type="Submit" value="Cadastrar" />
</form>
</body>
</html>