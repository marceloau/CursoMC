/**
 * 
 */
package com.aurino.cursoau.type;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.aurino.cursoau.dominio.Endereco;

/**
 * @author marcelo.aurino
 *
 */
public class EnderecoType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoEndereco;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=254, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String logradouro;
	@Length(min=1, max=10, message="O tamanho deve ser entre 1 e 10 caracteres")
	private String numero;
	private String complemento;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=1, max=100, message="O tamanho deve ser entre 1 e 100 caracteres")
	private String bairro;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=8, max=9, message="O tamanho deve ser entre 8 e 9 caracteres")
	private String cep;
	@NotEmpty(message="Preenchimento Obrigatório")
	private CidadeType cidade;
	
	/**
	 * 
	 */
	public EnderecoType() {
	}
	

	/**
	 * @param endereco Endereco
	 */
	public EnderecoType(Endereco endereco) {
		super();
		this.codigoEndereco = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
	}


	/**
	 * @return the codigoEndereco
	 */
	public Long getCodigoEndereco() {
		return codigoEndereco;
	}


	/**
	 * @param codigoEndereco the codigoEndereco to set
	 */
	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}


	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}


	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}


	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}


	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/**
	 * @return the cidade
	 */
	public CidadeType getCidade() {
		return cidade;
	}


	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(CidadeType cidade) {
		this.cidade = cidade;
	}	
}
