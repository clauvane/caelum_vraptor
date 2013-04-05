package br.com.caelum.goodbuy.infra;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class CriadorDeSessao {
	
	public static Session getSession(){
		try {
			AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
			annotationConfiguration.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			return session;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("Erro ao criar Sessao do hibernate!");
		}
	}
	
}
