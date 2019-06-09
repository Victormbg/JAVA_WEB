package br.com.livraria.controller;

import java.util.List;

import br.com.livraria.Autor;
import br.com.livraria.dao.autorDAO;

public class AutorController {
	public List<Autor> listarAutor(){
		autorDAO dao = new autorDAO();
		return dao.listar();
	}
	
	public void incluirAutor(Autor autor) {
		autorDAO dao = new autorDAO();
		dao.incluir(autor);
	}
	
	public void excluirAutor(long id) {
	    autorDAO dao = new autorDAO();
	    dao.excluir(id);
	    }
	
	public Autor buscarAutor(long id) {
		autorDAO dao = new autorDAO();
		return dao.buscar(id);
	}
	
	public void alterarAutor(Autor a) {
	    autorDAO dao = new autorDAO();
	    dao.alterar(a);
	    }
}

