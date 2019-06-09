package br.com.lanchonete.servlets;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessaFormServlet
 */
@WebServlet("/ProcessaFormServlet")
public class ProcessaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessaFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		request.setAttribute("valor", strValorTotal);
		
		RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
		
		rd.forward(request, response);
	
	}

}
