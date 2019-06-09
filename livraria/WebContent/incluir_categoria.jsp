<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="formI" method="post" action="categoria" >
<input type="hidden" name="acao" 
 value="${requestScope['acao'] }"/>
<input type="hidden" name="id"
 value="${requestScope ['categoria'].getId() }"/>
Código:
<input type="text" name="txtCodigo" 
value="${requestScope['categoria'].getCodigo() }"/><br>
Descrições:
<input type="text" name="txtDescricao"
value="${requestScope['categoria'].getDescricao() }"/><br>


<input type="Submit" value="Cadastrar" />
</form>
</body>
</html>