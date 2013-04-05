package br.com.caelum.goodbuy.infra;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.modelo.Produto;

public class ProdutoDao {
	
	public boolean salva(Produto produto){
		
		Session session = CriadorDeSessao.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(produto);
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException("Erro ao salvar Produto!");
		}finally{
			session.close();
		}
	}
	
}
