/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")	
	private Long id;
	@JsonFormat(pattern="dd/MM/yyyy hh:mm:ss")
	@Column(name="dataPedido")
	private Date dataPedido;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="endereco_entrega_id")
	private Endereco enderecoEntrega;
	
	@OneToMany(mappedBy="itemPedidoPK.pedido")
	private List<ItemPedido> itens = new ArrayList<>();
	
	/**
	 * 
	 */
	public Pedido() {
	}

	/**
	 * @param id
	 * @param dataPedido
	 * @param pagamento
	 * @param cliente
	 * @param enderecoEntrega
	 */
	public Pedido(final Long id, final Date dataPedido, final Cliente cliente, final Endereco enderecoEntrega) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for(final ItemPedido itemPedido : this.itens) {
			valorTotal = valorTotal.add(itemPedido.getSubTotal());
		}
		return valorTotal;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataPedido
	 */
	public Date getDataPedido() {
		return dataPedido;
	}

	/**
	 * @param dataPedido the dataPedido to set
	 */
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the enderecoEntrega
	 */
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	/**
	 * @param enderecoEntrega the enderecoEntrega to set
	 */
	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	/**
	 * @return the itens
	 */
	public List<ItemPedido> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
