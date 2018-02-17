/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.aurino.cursoau.dominio.Contato;

/**
 * @author marcelo.aurino
 *
 */
public class ContatoType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoCliente;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=254, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String telefone;
	@NotEmpty(message="Preenchimento Obrigatório")
	private Integer codigoTipoContato;
	
	/**
	 * 
	 */
	public ContatoType() {
	}
	

	/**
	 * @param contato Contato
	 */
	public ContatoType(Contato contato) {
		super();
		this.nome = contato.getNome();
		this.codigoTipoContato = contato.getCodigoTipoContato();
		this.telefone = contato.getTelefone();
	}


	/**
	 * @return the codigoCliente
	 */
	public Long getCodigoCliente() {
		return codigoCliente;
	}


	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
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
}
