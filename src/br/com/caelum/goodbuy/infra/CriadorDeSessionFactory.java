package br.com.caelum.goodbuy.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory>{
	
	private SessionFactory sessionFactory;

	@PostConstruct
	public void abre(){
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration.configure("hibernate.cfg.xml");
		sessionFactory = annotationConfiguration.buildSessionFactory();
	}

	public SessionFactory getInstance() {
		return sessionFactory;
	}
	
	@PreDestroy
	public void fecha(){
		sessionFactory.close();
	}

}
