package br.com.joaldo.jpa.testes;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.util.Conexao;

public class CriaContaComSaldo {
	public static void main(String[] args) {

		EntityManager em = Conexao.getEntity();

		Conta conta = new Conta();
		conta.setAgencia(5234);
		conta.setNumero(98345);
		conta.setTitula("Merilo");

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		conta.setSaldo(190.0);
		
//		em.close();
//		
//		
//		EntityManager em2 = Conexao.getEntity();
//		conta.setSaldo(800.0);
//		em2.getTransaction().begin();
//		em2.merge(conta);
//		em2.getTransaction().commit();
	}
}
