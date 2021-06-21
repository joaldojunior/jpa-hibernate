package br.com.joaldo.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.joaldo.jpa.modelo.Categoria;
import br.com.joaldo.jpa.modelo.Movimentacao;
import br.com.joaldo.jpa.util.Conexao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManager em = Conexao.getEntity();

		Categoria categoria = new Categoria();
		categoria.setId(2L);
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categoria: " + movimentacao.getCategoria());
			System.out.println("Descricao " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
