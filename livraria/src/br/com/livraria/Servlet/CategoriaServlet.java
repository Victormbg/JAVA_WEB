package br.com.livraria.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.Categoria;
import br.com.livraria.controller.CategoriaController;

/**
 * Servlet implementation class Categoria_pr
 */
@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processar(request, response);
	}
	private void processar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("inicioInclusao")) {
			Categoria categoria = new Categoria();
			request.setAttribute("categoria", categoria);
			request.setAttribute("acao", "incluir");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir_categoria.jsp");
			rd.forward(request, response);
		}
		
		if(acao.equalsIgnoreCase("incluir")) {
			
			String codigo = request.getParameter("txtCodigo");
			String descricao = request.getParameter("txtDescricao");
			int id = Integer.parseInt(request.getParameter("id"));
		
			Categoria categoria = new Categoria();
			categoria.setId(id);
			categoria.setCodigo(codigo);
			categoria.setDescricao(descricao);
			
			
			
			CategoriaController controller = new CategoriaController();
			controller.incluirCategoria(categoria);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista_categoria.jsp");
			rd.forward(request, response);
		}
		
		if (acao.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			CategoriaController controller = new CategoriaController();
			controller.excluirCategoria(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista_categoria.jsp");
			rd.forward(request, response);
		}
		if(acao.equalsIgnoreCase("buscar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			CategoriaController controller = new CategoriaController();
			Categoria categoria = controller.buscarCategoria(id);
			
			request.setAttribute("categoria",categoria);
			request.setAttribute("acao", "alterar");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir_categoria.jsp");
			rd.forward(request, response);
			
		}
		if(acao.equalsIgnoreCase("alterar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String codigo = request.getParameter("txtCodigo");
			String descricao = request.getParameter("txtDescricao");
		
		
			Categoria categoria = new Categoria();
			categoria.setId(id);
			categoria.setCodigo(codigo);
			categoria.setDescricao(descricao);
			
			
			
			CategoriaController controller = new CategoriaController();
			controller.alterarCategoria(categoria);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista_categoria.jsp");
			rd.forward(request, response);
		}
	}
}
