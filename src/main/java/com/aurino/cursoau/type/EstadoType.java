/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.aurino.cursoau.dominio.Estado;

/**
 * @author marcelo.aurino
 *
 */
public class EstadoType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoEstado;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=254, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	/**
	 * 
	 */
	public EstadoType() {
	}
	

	/**
	 * @param estado Estado
	 */
	public EstadoType(Estado estado) {
		super();
		this.codigoEstado = estado.getId();
		this.nome = estado.getNome();
	}


	/**
	 * @return the codigoEstado
	 */
	public Long getCodigoEstado() {
		return codigoEstado;
	}


	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(Long codigoEstado) {
		this.codigoEstado = codigoEstado;
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
