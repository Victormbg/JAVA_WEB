<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastar Autor</title>
</head>
<body>
<h1>Cadastar Autor:</h1>
<form name="formI" method="post" action="ProcessoAutor">
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