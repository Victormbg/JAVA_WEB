<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<form name="formI" method="post" action="Autor_pr" >
<input type="hidden" name="acao" 
 value="${requestScope['acao'] }"/>
<input type="hidden" name="id"
 value="${requestScope ['autor'].getId() }"/>
Nome:
<input type="text" name="txtNome"
value="${requestScope['autor'].getNome() }"/><br>
Nacionalidade:
<input type="text" name="txtNacionalidade"
value="${requestScope['autor'].getNacionalidade() }"/><br>


<input type="Submit" value="Cadastrar" />
</form>
</body>
</html>