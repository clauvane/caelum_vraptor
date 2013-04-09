package br.com.caelum.goodbuy.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.Length;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;

@Entity
public class Produto{

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "O campo <b>nome</b> precisa ser preenchido!")
	@Length(min = 3, message = "O campo <b>nome</b> deve possuir no minimo 3 caracteres!")
	private String nome;
	
	@NotNull(message = "O campo <b>descricao</b> precisa ser preenchido!")
	@Length(max = 40, message = "O campo <b>descricao</b> deve possuir no maximo 40 caracteres!")
	private String descricao;
	
	@NotNull(message = "O campo <b>preco</b> precisa ser preenchido!")
	@Min(value = 0, message = "O campo <b>preco</b> nao pode ser negativo!")
	private Double preco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
