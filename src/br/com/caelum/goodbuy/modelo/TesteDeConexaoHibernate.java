package br.com.caelum.goodbuy.modelo;

public class TesteDeConexaoHibernate {
	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setNome("MacBook");
		produto.setDescricao("NoteBokk da apple");
		produto.setPreco(3.799);
		
//		new ProdutoDao().salva(produto);
//		Long id = new Long("21");
//		Produto p = new ProdutoDao().getProduto(id);
//		p.getNome();
	}
}
