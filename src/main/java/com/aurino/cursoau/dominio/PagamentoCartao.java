/**
 * 
 */
package com.aurino.cursoau.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aurino.cursoau.enums.StatusPagamento;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="pagamentos_cartao")
public class PagamentoCartao extends Pagamento {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroParcelas;
	
	/**
	 * 
	 */
	public PagamentoCartao() {
	}

	/**
	 * @param id
	 * @param codigoStatus
	 * @param pedido
	 */
	public PagamentoCartao(Long id, StatusPagamento codigoStatus, Pedido pedido, final Integer numeroParcelas) {
		super(id, codigoStatus, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	/**
	 * @return the numeroParcelas
	 */
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	/**
	 * @param numeroParcelas the numeroParcelas to set
	 */
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
