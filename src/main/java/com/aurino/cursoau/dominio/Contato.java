/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author marcelo.aurino
 *
 */
@Embeddable
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="nome")
	private String nome;
	@Column(name="telefone")
	private String telefone;
	@Column(name="codigoTipoContato")
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
