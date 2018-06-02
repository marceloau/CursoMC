/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aurino.cursoau.enums.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="pagamentos_boleto")
@JsonTypeName("pagamentoBoleto")
public class PagamentoBoleto extends Pagamento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern="dd/MM/yyyy hh:mm:ss")
	@Column(name="dataVencimento")
	private Date dataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy hh:mm:ss")
	@Column(name="dataPagamento")
	private Date dataPagamento;
	
	/**
	 * 
	 */
	public PagamentoBoleto() {
	}

	/**
	 * @param id
	 * @param codigoStatus
	 * @param pedido
	 */
	public PagamentoBoleto(Long id, StatusPagamento codigoStatus, Pedido pedido, final Date dataVencimento, final Date dataPagamento) {
		super(id, codigoStatus, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	

}
