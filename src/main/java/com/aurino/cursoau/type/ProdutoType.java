/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class ProdutoType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoProduto;
	private String nome;
	private BigDecimal preco;
	
	/**
	 * 
	 */
	public ProdutoType() {
	}

	/**
	 * @return the codigoProduto
	 */
	public Long getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * @param codigoProduto the codigoProduto to set
	 */
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
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
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	
}
