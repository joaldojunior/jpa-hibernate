package br.com.joaldo.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contas");
	
	public static EntityManager getEntity() {
		return EMF.createEntityManager();
		
	}

}
