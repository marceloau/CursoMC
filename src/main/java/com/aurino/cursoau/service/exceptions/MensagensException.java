package com.aurino.cursoau.service.exceptions;

public enum MensagensException {

	/**
	 * Mensagem registro não encontrado.
	 */
	REGISTRO_NAO_ENCONTRADO("error.business.registroNaoEncontrado",
			"Não foi encontrado nenhum registro com estes parametros de busca.");
	
	/**
	 * String for message code.
	 */
	private String code;

	/**
	 * String for message value.
	 */
	private String value;

	/**
	 * StatusVersao enum constructor.
	 *
	 * @param code
	 *            - the String code of the message.
	 * @param value
	 *            - the String value of the message.
	 */
	MensagensException(final String code, final String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * This method gets the code of the message.
	 *
	 * @return String code - the message code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method gets the value of the message.
	 *
	 * @return String value - the message value.
	 */
	public String getValue() {
		return value;
	}
	
}
