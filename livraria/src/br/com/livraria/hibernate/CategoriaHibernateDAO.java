package br.com.livraria.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.livraria.Categoria;

public class CategoriaHibernateDAO  implements HibernateDaoInterface<Categoria, Integer>  {


    @Override
    public List<Categoria> listar() {
    	EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("tarefas");
    	EntityManager manager = factory.createEntityManager();

    	List<Categoria> lista = manager
    	        .createQuery("select c from Categoria as c ")
    	        .getResultList();    	
    	
    	manager.close();
        return lista;
    }
	@Override
	public void incluir(Categoria obj) {
		// TODO Auto-generated method stub

	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();        
	    manager.persist(obj);
	    manager.getTransaction().commit();    

	    manager.close();
	}
	@Override
	public Categoria buscar(Integer numero) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

        Categoria c = manager.find(Categoria.class, numero);

	    return c;
	}
	@Override
	public void alterar(Categoria obj) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();
	    manager.merge(obj);
	    manager.getTransaction().commit();
	    
	    manager.close();
	    
	}
	@Override
	public void excluir(Integer numero) {
		// TODO Auto-generated method stub
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    Categoria c = manager.find(Categoria.class, numero);

		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
		
		manager.close();
	}
}
