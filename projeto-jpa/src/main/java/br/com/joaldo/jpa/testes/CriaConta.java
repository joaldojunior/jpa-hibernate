package br.com.joaldo.jpa.testes;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.util.Conexao;

public class CriaConta {
	
	public static void main(String[] args) {
		
		EntityManager em = Conexao.getEntity();
		
		Conta conta = new Conta();
		conta.setAgencia(1234);
		conta.setNumero(12345);
		conta.setTitula("Jotinha");
		
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		
	}
}
