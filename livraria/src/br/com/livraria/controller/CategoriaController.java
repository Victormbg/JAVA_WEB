package br.com.livraria.controller;

import java.util.List;

import br.com.livraria.Categoria;
import br.com.livraria.dao.CategoriaDAO;
import br.com.livraria.hibernate.CategoriaHibernateDAO;

public class CategoriaController {
	public List<Categoria> listarCategoria(){
		CategoriaHibernateDAO hibDAO = new CategoriaHibernateDAO();
		
		return hibDAO.listar();
	}
	
	public void incluirCategoria(Categoria categoria) {
		CategoriaHibernateDAO hibDAO = new CategoriaHibernateDAO();
		hibDAO.incluir(categoria);
	}
	
	public void excluirCategoria(int id) {
	    CategoriaHibernateDAO dao = new CategoriaHibernateDAO();
	    dao.excluir(id);
	    }
	
	public Categoria buscarCategoria(int id) {
		CategoriaHibernateDAO dao = new CategoriaHibernateDAO();
		return dao.buscar(id);
	}
	
	public void alterarCategoria(Categoria c) {
	    CategoriaHibernateDAO dao = new CategoriaHibernateDAO();
	    dao.alterar(c);
	    }
}
