/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.aurino.cursoau.dominio.Cidade;

/**
 * @author marcelo.aurino
 *
 */
public class CidadeType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoCidade;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=254, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	private EstadoType estado;
	
	/**
	 * 
	 */
	public CidadeType() {
	}
	

	/**
	 * @param cidade Cidade
	 */
	public CidadeType(Cidade cidade) {
		super();
		this.codigoCidade = cidade.getId();
		this.nome = cidade.getNome();
	}


	/**
	 * @return the codigoCidade
	 */
	public Long getCodigoCidade() {
		return codigoCidade;
	}


	/**
	 * @param codigoCidade the codigoCidade to set
	 */
	public void setCodigoCidade(Long codigoCidade) {
		this.codigoCidade = codigoCidade;
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
	 * @return the estado
	 */
	public EstadoType getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoType estado) {
		this.estado = estado;
	}
	
}
