/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;
import java.util.List;

import com.aurino.cursoau.dominio.Categoria;

/**
 * @author marcelo.aurino
 *
 */
public class CategoriaType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoCategoria;
	private String nome;
	private List<ProdutoType> produtos;
	
	/**
	 * 
	 */
	public CategoriaType() {
	}
	

	/**
	 * @param codigoCategoria
	 * @param nome
	 * @param produtos
	 */
	public CategoriaType(Categoria categoria) {
		super();
		this.codigoCategoria = categoria.getId();
		this.nome = categoria.getNome();
	}


	/**
	 * @return the codigoCategoria
	 */
	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the produtos
	 */
	public List<ProdutoType> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<ProdutoType> produtos) {
		this.produtos = produtos;
	}

}
