package br.com.livraria.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.Autor;
import br.com.livraria.Categoria;

public class AutorHibernateDAO implements HibernateDaoInterface<Autor, Integer> {

	@Override
	public List<Autor> listar() {
	  	EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("tarefas");
    	EntityManager manager = factory.createEntityManager();

    	List<Autor> lista = manager
    	        .createQuery("select a from Autor as a ")
    	        .getResultList();    	
    	
    	manager.close();
        return lista;
	}

	@Override
	public void incluir(Autor obj) {

	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();        
	    manager.persist(obj);
	    manager.getTransaction().commit();    

	    manager.close();
	}

	@Override
	public Autor buscar(Integer numero) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

        Autor a = manager.find(Autor.class, numero);

	    return a;
	}

	@Override
	public void alterar(Autor obj) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();
	    manager.merge(obj);
	    manager.getTransaction().commit();
	    
	    manager.close();
	}

	@Override
	public void excluir(Integer numero) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    Autor a = manager.find(Autor.class, numero);

		manager.getTransaction().begin();
		manager.remove(a);
		manager.getTransaction().commit();
		
		manager.close();
	}

}
