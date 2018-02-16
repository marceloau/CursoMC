/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.aurino.cursoau.dominio.Cliente;

/**
 * @author marcelo.aurino
 *
 */
public class ClienteType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoCliente;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=254, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="Email inválido")
	private String email;
	private String cpfCNPJ;
	private Integer codigoTipoCliente;
	
	/**
	 * 
	 */
	public ClienteType() {
	}
	

	/**
	 * @param codigoCategoria
	 * @param nome
	 * @param produtos
	 */
	public ClienteType(Cliente cliente) {
		super();
		this.codigoCliente = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpfCNPJ = cliente.getCpfCNPJ();
		this.codigoTipoCliente = cliente.getCodigoTipoCliente();
	}
	
	/**
	 * @return the cpfCNPJ
	 */
	public String getCpfCNPJ() {
		return cpfCNPJ;
	}


	/**
	 * @param cpfCNPJ the cpfCNPJ to set
	 */
	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}


	/**
	 * @return the codigoTipoCliente
	 */
	public Integer getCodigoTipoCliente() {
		return codigoTipoCliente;
	}


	/**
	 * @param codigoTipoCliente the codigoTipoCliente to set
	 */
	public void setCodigoTipoCliente(Integer codigoTipoCliente) {
		this.codigoTipoCliente = codigoTipoCliente;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	public void setCodigoCliente(final Long codigoCliente) {
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
