package br.com.livraria.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("tarefas");

		factory.close();
	}

}
