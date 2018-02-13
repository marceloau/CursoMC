/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aurino.cursoau.enums.StatusPagamento;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="pagamentos")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pagamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name="codigo")
	private Long id;
	@Column(name="codigoStatus")
	private StatusPagamento codigoStatus;
	
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	/**
	 * 
	 */
	public Pagamento() {
	}

	/**
	 * @param id
	 * @param codigoStatus
	 * @param pedido
	 */
	public Pagamento(Long id, StatusPagamento codigoStatus, Pedido pedido) {
		super();
		this.id = id;
		this.codigoStatus = codigoStatus;
		this.pedido = pedido;
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
	 * @return the codigoStatus
	 */
	public StatusPagamento getCodigoStatus() {
		return codigoStatus;
	}

	/**
	 * @param codigoStatus the codigoStatus to set
	 */
	public void setCodigoStatus(StatusPagamento codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
