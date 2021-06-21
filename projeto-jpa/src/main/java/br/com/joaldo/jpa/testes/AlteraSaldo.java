package br.com.joaldo.jpa.testes;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.util.Conexao;

public class AlteraSaldo {

	public static void main(String[] args) {

		EntityManager em = Conexao.getEntity();

		Conta conta = em.find(Conta.class, 3L);
		
		
		em.getTransaction().begin();
		conta.setTitula("Carlos");
		em.getTransaction().commit();
		
		
	}
}
