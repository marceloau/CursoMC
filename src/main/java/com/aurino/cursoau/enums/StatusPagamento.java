/**
 * 
 */
package com.aurino.cursoau.enums;

/**
 * @author marcelo.aurino
 *
 */
public enum StatusPagamento {

	PENDENTE(1,"Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	/**
	 * String for message code.
	 */
	private Integer codigo;

	/**
	 * String for message value.
	 */
	private String descricao;

	/**
	 * StatusVersao enum constructor.
	 *
	 * @param codigo
	 *            - the String code of the message.
	 * @param descricao
	 *            - the String value of the message.
	 */
	StatusPagamento(final Integer codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static StatusPagamento toEnum(Integer codigo) {
		
		StatusPagamento retorno = null;
		
		if(codigo == null) {
			retorno = null;
		}else {		
			for(StatusPagamento statusPagamento : StatusPagamento.values()) {
				if(codigo.equals(statusPagamento.getCodigo())) {
					retorno = statusPagamento;
				}
			}
		}
		
		return retorno;
	}
	
	/**
	 * This method gets the code of the message.
	 *
	 * @return String code - the message code.
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * This method gets the value of the message.
	 *
	 * @return String value - the message value.
	 */
	public String getDescricao() {
		return descricao;
	}
}
