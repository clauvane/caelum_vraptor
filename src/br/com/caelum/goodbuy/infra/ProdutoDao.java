package br.com.caelum.goodbuy.infra;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProdutoDao {

	private Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void salva(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaTudo() {
		Criteria criteria = session.createCriteria(Produto.class);
		return criteria.list();
	}

	public Produto getProduto(Long id) {
		return (Produto) session.load(Produto.class, id);
	}

	public void atualiza(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.update(produto);
		transaction.commit();
	}

	public void remove(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> busca(String nome) {
		Criteria criteria = session.createCriteria(Produto.class);
		criteria.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
		return criteria.list();
	}

	public void recarrega(Produto produto) {
		session.refresh(produto);
	}
}
