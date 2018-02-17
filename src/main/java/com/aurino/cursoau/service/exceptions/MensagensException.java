package com.aurino.cursoau.service.exceptions;

public enum MensagensException {

	/**
	 * Mensagem registro não encontrado.
	 */
	REGISTRO_NAO_ENCONTRADO("error.business.registroNaoEncontrado",
			"Não foi encontrado nenhum registro com estes parametros de busca."),
	
	/**
	 * Mensagem categoria com produtos associados.
	 */
	CATEGORIA_COM_PRODUTOS("error.business.categoriaComProdutos",
			"Não é possível excluir uma categoria com produtos associados a mesma."),
	
	/**
	 * Mensagem cliente com pedidos associados.
	 */
	CLIENTE_COM_PEDIDOS("error.business.clienteComPedidos",
			"Não é possível excluir um cliente com pedidos associados ao mesmo."),
	
	/**
	 * Mensagem cliente com pedidos associados.
	 */
	ENDERECO_SEM_CIDADE("error.business.enderecoSemCidade",
			"Não é possível salvar um endereço sem ter uma cidade informada.");
	
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
