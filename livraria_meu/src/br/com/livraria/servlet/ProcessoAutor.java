package br.com.livraria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.Autor;
import br.com.livraria.controller.AutorController;

/**
 * Servlet implementation class ProcessoAutor
 */
@WebServlet("/ProcessoAutor")
public class ProcessoAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessoAutor() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processar(request, response);
	}
	
	private void processar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("inicioInclusao")) {
			Autor autor = new Autor();
			request.setAttribute("autor",autor);
			request.setAttribute("acao", "incluir");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir.jsp");
			rd.forward(request, response);
		}
		
		if(acao.equalsIgnoreCase("incluir")) {
			
			String nome = request.getParameter("txtNome");
			String nacionalidade = request.getParameter("txtNacionalidade");
			
			Autor autor = new Autor();
			autor.setNome(nome);
			autor.setNacionalidade(nacionalidade);
			
			AutorController controller = new AutorController();
			controller.incluirAutor(autor);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
		
		if (acao.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			AutorController controller = new AutorController();
			controller.excluirAutor(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
		if(acao.equalsIgnoreCase("buscar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			AutorController controller = new AutorController();
			Autor autor = controller.buscarAutor(id);
			
			request.setAttribute("autor",autor);
			request.setAttribute("acao", "alterar");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("incluir.jsp");
			rd.forward(request, response);
			
		}
		if(acao.equalsIgnoreCase("alterar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("txtNome");
			String nacionalidade = request.getParameter("txtNacionalidade");
			
			Autor autor = new Autor();
			autor.setId(id);
			autor.setNome(nome);
			autor.setNacionalidade(nacionalidade);
			AutorController controller = new AutorController();
			controller.alterarAutor(autor);
			
			RequestDispatcher rd = request.getRequestDispatcher("paginaAutor.jsp");
			rd.forward(request, response);
		}
	}

}
