<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DecimalFormat;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int codigoProduto = Integer.parseInt(request.getParameter("selProduto"));	
		int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
		double valorTotal = 0.00;
		if(codigoProduto == 100){
			valorTotal = 5 * quantidade;
		}else if(codigoProduto == 101){
			valorTotal = 10 * quantidade;
		}else if(codigoProduto == 102){
			valorTotal = 10.5 * quantidade;
		}else if(codigoProduto == 103){
			valorTotal = 5 * quantidade;
		}else if(codigoProduto == 104){
			valorTotal = 6 * quantidade;
		}else if(codigoProduto == 105){
			valorTotal = 4 * quantidade;
		}
		DecimalFormat formato = new DecimalFormat("##0.00");
		String strValorTotal = formato.format(valorTotal);
		
		RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
		
		rd.forward(request, response);
	
	%>
	<h3>O valor total do pedido é <%=valorTotal %></h3>
	
</body>
</html>