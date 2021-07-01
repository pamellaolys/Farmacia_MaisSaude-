package br.com.generation.farmaciamaissaude.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produtos_MaisSaude")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min= 2, max = 100)
	private String produto;
	
	@NotNull
	private Double preco;
	
	@NotNull
	private String fabricante;
	
	private Boolean receituario;
	
	private Boolean generico;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String descricaoproduto) {
		this.produto = descricaoproduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Boolean getReceituario() {
		return receituario;
	}

	public void setReceituario(Boolean receituario) {
		this.receituario = receituario;
	}

	public Boolean getGenerico() {
		return generico;
	}

	public void setGenerico(Boolean generico) {
		this.generico = generico;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
