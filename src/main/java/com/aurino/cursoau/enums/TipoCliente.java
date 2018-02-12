/**
 * 
 */
package com.aurino.cursoau.enums;

/**
 * @author marcelo.aurino
 *
 */
public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
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
	TipoCliente(final Integer codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		
		TipoCliente retorno = null;
		
		if(codigo == null) {
			retorno = null;
		}else {		
			for(TipoCliente tipoCliente : TipoCliente.values()) {
				if(codigo.equals(tipoCliente.getCodigo())) {
					retorno = tipoCliente;
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
