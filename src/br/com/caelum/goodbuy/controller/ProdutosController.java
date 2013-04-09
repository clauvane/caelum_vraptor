package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.infra.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public List<Produto> lista() {
		return dao.listaTudo();
	}

	public void adiciona(Produto produto) {
		
		validaFormulario(produto);
		
		dao.salva(produto);
		result.redirectTo(this).lista();
	}


	public void formulario() {
	}

	public Produto edita(Long id) {
		return dao.getProduto(id);
	}

	public void altera(Produto produto) {
		
		validaFormulario(produto);
		
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	public void remove(Long id) {
		Produto produto = dao.getProduto(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}

	private void validaFormulario(Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).formulario();
	}
}
