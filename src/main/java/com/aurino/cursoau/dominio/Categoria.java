package com.aurino.cursoau.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer categoriaPK;
	
	@NotNull
	@Column(name="nome", nullable=false)
	private String nome;
	
	public Categoria() {
	}
	
	public Categoria(Integer categoriaPK, String nome) {
		super();
		categoriaPK = categoriaPK;
		this.nome = nome;
	}

	public Integer getCategoriaPK() {
		return categoriaPK;
	}
	public void setCategoriaPK(Integer categoriaPK) {
		categoriaPK = categoriaPK;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaPK == null) ? 0 : categoriaPK.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoriaPK == null) {
			if (other.categoriaPK != null)
				return false;
		} else if (!categoriaPK.equals(other.categoriaPK))
			return false;
		return true;
	}
	
	

}
