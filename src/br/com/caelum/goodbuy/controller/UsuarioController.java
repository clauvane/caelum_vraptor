package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.infra.UsuarioDao;
import br.com.caelum.goodbuy.modelo.Usuario;
import br.com.caelum.goodbuy.modelo.UsuarioWeb;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuarioController {

	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;
	private UsuarioWeb usuarioWeb;

	public UsuarioController(UsuarioDao usuarioDao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Post("/usuario")
	public void adiciona(Usuario usuario) {
		if (usuarioDao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Login já existe",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(this).novo();
		usuarioDao.salva(usuario);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Get("/usuario/novo")
	public void novo() {

	}

	@Get("/login")
	public void loginForm() {

	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = usuarioDao.carrega(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutosController.class).lista();
	}

}
