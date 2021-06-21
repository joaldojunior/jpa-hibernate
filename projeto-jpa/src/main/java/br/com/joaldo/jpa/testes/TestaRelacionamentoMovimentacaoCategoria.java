package br.com.joaldo.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.joaldo.jpa.modelo.Categoria;
import br.com.joaldo.jpa.modelo.Conta;
import br.com.joaldo.jpa.modelo.Movimentacao;
import br.com.joaldo.jpa.modelo.TipoMovimentacao;
import br.com.joaldo.jpa.util.Conexao;

public class TestaRelacionamentoMovimentacaoCategoria {
	public static void main(String[] args) {
		
		EntityManager em = Conexao.getEntity();
		
		Categoria categoria = new Categoria("Viagem");
		
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a sp");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		movimentacao.setConta(conta);
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem ao rio");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(200.0));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}

}
