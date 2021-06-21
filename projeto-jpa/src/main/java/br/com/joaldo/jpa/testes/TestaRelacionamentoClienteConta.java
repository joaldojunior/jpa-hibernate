package br.com.joaldo.jpa.testes;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.modelo.Cliente;
import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.util.Conexao;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		EntityManager em = Conexao.getEntity();
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Glauber");
		cliente.setEndereco("Rua da pedra, 0123");
		cliente.setProfissao("Instrutor");
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
