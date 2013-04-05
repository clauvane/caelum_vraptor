package br.com.caelum.goodbuy.modelo;

import br.com.caelum.goodbuy.infra.ProdutoDao;

public class TesteDeConexaoHibernate {
	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setNome("MacBook");
		produto.setDescricao("NoteBokk da apple");
		produto.setPreco(3.799);
		
		new ProdutoDao().salva(produto);
	}
}
