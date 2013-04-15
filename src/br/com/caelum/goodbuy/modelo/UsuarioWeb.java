package br.com.caelum.goodbuy.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {
	
	private Usuario logado;

	public void login(Usuario usuario) {
		this.logado = usuario;
	}
	
	public boolean isLogado() {
		return logado != null;
	}
	
	public String getNome(){
		return logado.getNome();
	}

	public void logout() {
		logado = null;
	}
	
}
