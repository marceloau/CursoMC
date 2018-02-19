/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="itemPedidos")
public class ItemPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK itemPedidoPK;
	@Column(name="desconto")
	private BigDecimal desconto;
	@Column(name="quantidade")
	private Integer quantidade;
	@Column(name="preco")
	private BigDecimal preco;
	
	
	/**
	 * 
	 */
	public ItemPedido() {
	}


	/**
	 * @param itemPedidoPK
	 * @param desconto
	 * @param quantidade
	 * @param preco
	 */
	public ItemPedido(Pedido pedido, Produto produto, BigDecimal desconto, Integer quantidade, BigDecimal preco) {
		super();
		this.itemPedidoPK = new ItemPedidoPK();
		this.itemPedidoPK.setPedido(pedido);
		this.itemPedidoPK.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public BigDecimal getSubTotal() {
		return (this.preco.subtract(this.desconto)).multiply(BigDecimal.valueOf(this.quantidade));
	}
	
	/**
	 * @return the pedido
	 */
	@JsonIgnore
	public Pedido getPedido() {
		return itemPedidoPK.getPedido();
	}
	
	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return itemPedidoPK.getProduto();
	}

	/**
	 * @return the itemPedidoPK
	 */
	public ItemPedidoPK getItemPedidoPK() {
		return itemPedidoPK;
	}


	/**
	 * @param itemPedidoPK the itemPedidoPK to set
	 */
	public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
		this.itemPedidoPK = itemPedidoPK;
	}


	/**
	 * @return the desconto
	 */
	public BigDecimal getDesconto() {
		return desconto;
	}


	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}


	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}


	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemPedidoPK == null) ? 0 : itemPedidoPK.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (itemPedidoPK == null) {
			if (other.itemPedidoPK != null)
				return false;
		} else if (!itemPedidoPK.equals(other.itemPedidoPK))
			return false;
		return true;
	}

}
