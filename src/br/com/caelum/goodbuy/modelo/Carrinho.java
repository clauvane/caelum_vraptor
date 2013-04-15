package br.com.caelum.goodbuy.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {

	private List<Item> listaDeItem = new ArrayList<Item>();
	private Double total = 0.0;

	public void adiciona(Item item) {
		listaDeItem.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
	}
	
	public void remove(int indice) {
		Item item = listaDeItem.remove(indice);
		total -= item.getProduto().getPreco() * item.getQuantidade();
	}
	
	public Integer getTotalDeItens(){
		return listaDeItem.size();
	}

	public List<Item> getListaDeItem() {
		return listaDeItem;
	}

	public void setListaDeItem(List<Item> listaDeItem) {
		this.listaDeItem = listaDeItem;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
