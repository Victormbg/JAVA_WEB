package br.com.livraria.controller;

import java.util.List;

import br.com.livraria.Livros;
import br.com.livraria.dao.livroDAO;

public class LivroController {
	public List<Livros> listarLivros(){
		livroDAO dao = new livroDAO();
		return dao.listar();
	}
	
	public void incluirLivro(Livros livro) {
		livroDAO dao = new livroDAO();
		dao.incluir(livro);
	}
	
	public void excluirLivro(long id) {
	    livroDAO dao = new livroDAO();
	    dao.excluir(id);
	    }
	
	public Livros buscarLivro(long id) {
		livroDAO dao = new livroDAO();
		return dao.buscar(id);
	}
	
	public void alterarLivro(Livros l) {
	    livroDAO dao = new livroDAO();
	    dao.alterar(l);
	    }
}

