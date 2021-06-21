package br.com.joaldo.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.modelo.Movimentacao;
import br.com.joaldo.jpa.util.Conexao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager em = Conexao.getEntity();
		
		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "select m from Movimentacao m where m.conta = :conta order by m.valor desc";
		
		TypedQuery<Movimentacao> createQuery = em.createQuery(jpql, Movimentacao.class);
		createQuery.setParameter("conta", conta);
		List<Movimentacao> resultList = createQuery.getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descricao " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}

}
