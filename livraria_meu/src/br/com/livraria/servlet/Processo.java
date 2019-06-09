package br.com.livraria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.Livros;
import br.com.livraria.controller.LivroController;

/**
 * Servlet implementation class Processo
 */
@WebServlet("/Processo")
public class Processo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processar(request, response);
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processar(request, response);
	}
	
	private void processar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("inicioInclusao")) {
			Livros livro = new Livros();
			request.setAttribute("livro",livro);
			request.setAttribute("acao", "incluir");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir.jsp");
			rd.forward(request, response);
		}
		
		if(acao.equalsIgnoreCase("incluir")) {
			
			String titulo = request.getParameter("txtTitulo");
			String editora = request.getParameter("txtEditora");
			String autores = request.getParameter("txtAutores");
			int ISBN = Integer.parseInt(request.getParameter("txtISBN"));
			int ano = Integer.parseInt(request.getParameter("txtAno"));
			
			Livros livro = new Livros();
			livro.setISBN(ISBN);
			livro.setTitulo(titulo);
			livro.setAno(ano);
			livro.setEditora(editora);
			livro.setAutores(autores);
			
			LivroController controller = new LivroController();
			controller.incluirLivro(livro);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
		
		if (acao.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			LivroController controller = new LivroController();
			controller.excluirLivro(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
		if(acao.equalsIgnoreCase("buscar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			LivroController controller = new LivroController();
			Livros livro = controller.buscarLivro(id);
			
			request.setAttribute("livro",livro);
			request.setAttribute("acao", "alterar");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir.jsp");
			rd.forward(request, response);
			
		}
		if(acao.equalsIgnoreCase("alterar")) {
			
			String titulo = request.getParameter("txtTitulo");
			String editora = request.getParameter("txtEditora");
			String autores = request.getParameter("txtAutores");
			int ISBN = Integer.parseInt(request.getParameter("txtISBN"));
			int ano = Integer.parseInt(request.getParameter("txtAno"));
		
			Livros livro = new Livros();
			livro.setISBN(ISBN);
			livro.setTitulo(titulo);
			livro.setAno(ano);
			livro.setEditora(editora);
			livro.setAutores(autores);
			
			
			LivroController controller = new LivroController();
			controller.alterarLivro(livro);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
	}
}
