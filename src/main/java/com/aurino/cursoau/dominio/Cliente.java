/**
 * 
 */
package com.aurino.cursoau.dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aurino.cursoau.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author marcelo.aurino
 *
 */
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="cpfCNPJ")
	private String cpfCNPJ;
	@Column(name="codigoTipoCliente")
	private Integer codigoTipoCliente;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Endereco> enderecos;
	
	@ElementCollection
	@CollectionTable(name="contatos", joinColumns = @JoinColumn(name="codigoCliente"))
	private Set<Contato> contatos;
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	/**
	 * 
	 */
	public Cliente() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param cpfCNPJ
	 * @param tipoCliente
	 */
	public Cliente(Long id, String nome, String email, String cpfCNPJ, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCNPJ = cpfCNPJ;
		this.codigoTipoCliente = tipoCliente.getCodigo();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the tipoCliente
	 */
	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(this.codigoTipoCliente);
	}
	
	/**
	 * @return the tipoCliente
	 */
	public Integer getCodigoTipoCliente() {
		return codigoTipoCliente;
	}

	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.codigoTipoCliente = tipoCliente.getCodigo();
	}

	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * @return the contatos
	 */
	public Set<Contato> getContatos() {
		return contatos;
	}

	/**
	 * @param contatos the contatos to set
	 */
	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
