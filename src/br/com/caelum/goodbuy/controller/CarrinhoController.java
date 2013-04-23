package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.infra.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Carrinho;
import br.com.caelum.goodbuy.modelo.Item;
import br.com.caelum.goodbuy.modelo.Restrito;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CarrinhoController {

	private final ProdutoDao produtoDao;
	private final Carrinho carrinho;
	private final Result result;

	public CarrinhoController(Carrinho carrinho, ProdutoDao produtoDao, Result result) {
		this.carrinho = carrinho;
		this.produtoDao = produtoDao;
		this.result = result;
	}
	
	@Restrito
	@Post("/carrinho")
	public void adiciona(Item item){
		produtoDao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(this).visualiza();
	}
	
	@Restrito
	@Get("/carrinho")
	public void visualiza(){
	}
	
	@Restrito
	@Delete("/carrinho/{indiceItem}")
	public void remove(int indice){
		carrinho.remove(indice);
		result.redirectTo(this).visualiza();
	}
	
}
