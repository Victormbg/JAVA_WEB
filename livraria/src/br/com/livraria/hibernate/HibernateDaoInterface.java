package br.com.livraria.hibernate;

import java.io.Serializable;
import java.util.List;

public interface HibernateDaoInterface <T, Id extends Serializable> {

	public List<T> listar();
	
	public void incluir(T obj);
	
	public T buscar(Id numero);
	
	public void alterar(T obj);
	
	public void excluir(Id numero);
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      