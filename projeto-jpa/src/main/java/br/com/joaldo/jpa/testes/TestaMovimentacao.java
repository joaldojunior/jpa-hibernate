package br.com.joaldo.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.modelo.Movimentacao;
import br.com.joaldo.jpa.modelo.TipoMovimentacao;
import br.com.joaldo.jpa.util.Conexao;

public class TestaMovimentacao {

	public static void main(String[] args) {
		EntityManager em = Conexao.getEntity();
		
		Conta conta = new Conta();
		conta.setAgencia(23456);
		conta.setNumero(99987);
		conta.setSaldo(800.0);
		conta.setTitula("Osvaldo");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churras");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
		

	}

}
