package br.com.boletim.controller;

import java.util.List;

import br.com.boletim.Aluno;
import br.com.boletim.dao.AlunoDAO;

public class AlunoController {
	public List<Aluno> listarAlunos(){
		AlunoDAO dao = new AlunoDAO();
		return dao.listar();
	}
	
	public void incluirAluno(Aluno aluno) {
		AlunoDAO dao = new AlunoDAO();
		dao.incluir(aluno);
	}
	
	public void excluirAluno(long id) {
	    AlunoDAO dao = new AlunoDAO();
	    dao.excluir(id);
	    }
	
	public Aluno buscarAluno(long id) {
		AlunoDAO dao = new AlunoDAO();
		return dao.buscar(id);
	}
	
	public void alterarAluno(Aluno a) {
	    AlunoDAO dao = new AlunoDAO();
	    dao.alterar(a);
	    }
}

