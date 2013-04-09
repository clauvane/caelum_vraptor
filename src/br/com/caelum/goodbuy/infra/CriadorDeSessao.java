package br.com.caelum.goodbuy.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSessao implements ComponentFactory<Session> {

	private final SessionFactory sessionFactory;
	private Session session;

	public CriadorDeSessao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@PostConstruct
	public void abre(){
		session = sessionFactory.openSession();
	}

	public Session getInstance() {
		return session;
	}
	
	@PreDestroy
	public void fecha(){
		session.close();
	}
}
