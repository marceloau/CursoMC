/**
 * 
 */
package com.aurino.cursoau.resources.exceptions;

import java.io.Serializable;

/**
 * @author marcelo.aurino
 *
 */
public class CamposMensagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeCampo;
	private String mensagem;

	/**
	 * @param nomeCampo
	 * @param mensagem
	 */
	public CamposMensagem(String nomeCampo, String mensagem) {
		super();
		this.nomeCampo = nomeCampo;
		this.mensagem = mensagem;
	}

	/**
	 * 
	 */
	public CamposMensagem() {
	}
	
	/**
	 * @return the nomeCampo
	 */
	public String getNomeCampo() {
		return nomeCampo;
	}

	/**
	 * @param nomeCampo the nomeCampo to set
	 */
	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
