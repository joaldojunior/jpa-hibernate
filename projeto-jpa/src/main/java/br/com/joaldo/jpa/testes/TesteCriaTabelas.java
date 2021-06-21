package br.com.joaldo.jpa.testes;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.util.Conexao;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		
		EntityManager em = Conexao.getEntity();
		em.close();

	}

}
