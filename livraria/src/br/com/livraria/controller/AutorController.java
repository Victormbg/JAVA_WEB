package br.com.livraria.controller;

import java.util.List;

import br.com.livraria.Autor;
import br.com.livraria.dao.AutorDAO;

public class AutorController {
	
	public List<Autor> listarAutor(){
		AutorDAO dao = new AutorDAO();
		return dao.listar();
	}
	
	public void incluirAutor(Autor autor) {
		AutorDAO dao = new AutorDAO();
		dao.incluir(autor);
	}
	
	public void excluirAutor(long id) {
	    AutorDAO dao = new AutorDAO();
	    dao.excluir(id);
	    }
	
	public Autor buscarAutor(long id) {
		AutorDAO dao = new AutorDAO();
		return dao.buscar(id);
	}
	
	public void alterarAutor(Autor a) {
	    AutorDAO dao = new AutorDAO();
	    dao.alterar(a);
	    }
}
