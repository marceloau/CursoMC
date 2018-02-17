/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;

/**
 * @author marcelo.aurino
 *
 */
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String telefone;
	private Integer codigoTipoContato;

	/**
	 * 
	 */
	public Contato() {
	}
	
	/**
	 * @param nome
	 * @param telefone
	 * @param codigoTipoContato
	 */
	public Contato(String nome, String telefone, Integer codigoTipoContato) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.codigoTipoContato = codigoTipoContato;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the codigoTipoContato
	 */
	public Integer getCodigoTipoContato() {
		return codigoTipoContato;
	}

	/**
	 * @param codigoTipoContato the codigoTipoContato to set
	 */
	public void setCodigoTipoContato(Integer codigoTipoContato) {
		this.codigoTipoContato = codigoTipoContato;
	}
}
