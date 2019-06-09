package br.com.boletim.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.boletim.Aluno;
import br.com.boletim.controller.AlunoController;

/**
 * Servlet implementation class Boletim
 */
@WebServlet("/Boletim")
public class Boletim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boletim() {
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
			Aluno aluno = new Aluno();
			request.setAttribute("aluno",aluno);
			request.setAttribute("acao", "incluir");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("Incluir.jsp");
			rd.forward(request, response);
		}
		
		if(acao.equalsIgnoreCase("incluir")) {
			
			String nome = request.getParameter("txtNome");
			String matricula = request.getParameter("txtMatricula");
			double nota1 = Double.parseDouble(request.getParameter("txtNota1"));
			double nota2 = Double.parseDouble(request.getParameter("txtNota2"));
			double nota3= Double.parseDouble(request.getParameter("txtNota3"));
		
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setMatricula(matricula);
			aluno.setNota1(nota1);
			aluno.setNota2(nota2);
			aluno.setNota3(nota3);
			
			AlunoController controller = new AlunoController();
			controller.incluirAluno(aluno);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			rd.forward(request, response);
		}
		
		if (acao.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			AlunoController controller = new AlunoController();
			controller.excluirAluno(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			rd.forward(request, response);
		}
		if(acao.equalsIgnoreCase("buscar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			AlunoController controller = new AlunoController();
			Aluno aluno = controller.buscarAluno(id);
			
			request.setAttribute("aluno",aluno);
			request.setAttribute("acao", "alterar");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("Incluir.jsp");
			rd.forward(request, response);
			
		}
		if(acao.equalsIgnoreCase("alterar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("txtNome");
			String matricula = request.getParameter("txtMatricula");
			double nota1 = Double.parseDouble(request.getParameter("txtNota1"));
			double nota2 = Double.parseDouble(request.getParameter("txtNota2"));
			double nota3= Double.parseDouble(request.getParameter("txtNota3"));
		
			Aluno aluno = new Aluno();
			aluno.setId(id);
			aluno.setNome(nome);
			aluno.setMatricula(matricula);
			aluno.setNota1(nota1);
			aluno.setNota2(nota2);
			aluno.setNota3(nota3);
			
			
			AlunoController controller = new AlunoController();
			controller.alterarAluno(aluno);
			
			RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			rd.forward(request, response);
		}
	}
}