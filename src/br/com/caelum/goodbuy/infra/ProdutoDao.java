package br.com.caelum.goodbuy.infra;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.ioc.Component;

@Component
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

	@SuppressWarnings("unchecked")
	public List<Produto> listaTudo() {
		Session session = CriadorDeSessao.getSession();
		try {
			Criteria criteria = session.createCriteria(Produto.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException("Erro ao listar produtos!");
		}finally{
			session.close();
		}
	}

	public Produto getProduto(Long id) {
		Session session = CriadorDeSessao.getSession();
		try {
			return (Produto) session.load(Produto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException("Erro ao carregar produto!");
		}finally{
			session.close();
		}
	}
	
}
