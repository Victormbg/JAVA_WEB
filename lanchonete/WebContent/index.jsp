<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lanchonete</title>
</head>
<body>
	<form name="form1" method="post" action="ProcessaFormServlet">
	Selecione o seu pedido:
	<select name="selProduto">
	<option value="100">Cachorro quente</option>
	<option value="100">Baru simples</option>
	<option value="100">Bauru com ovo</option>
	<option value="100">Hamburguer</option>
	<option value="100">Cheeseburguer</option>
	<option value="100">Refrigerante</option>
	</select><br>
	
	Informe a quantidade:
	<input type="number" name="txtQuantidade" /> <br/>
	
	<input type="Submit" value="Enviar" />
	
	</form>
</body>
</html>