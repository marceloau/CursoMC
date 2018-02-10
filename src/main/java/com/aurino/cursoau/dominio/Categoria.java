package com.aurino.cursoau.dominio;

import java.io.Serializable;

public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer CategoriaPK;
	private String nome;
	
	public Categoria() {
	}
	
	public Categoria(Integer categoriaPK, String nome) {
		super();
		CategoriaPK = categoriaPK;
		this.nome = nome;
	}

	public Integer getCategoriaPK() {
		return CategoriaPK;
	}
	public void setCategoriaPK(Integer categoriaPK) {
		CategoriaPK = categoriaPK;
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
		result = prime * result + ((CategoriaPK == null) ? 0 : CategoriaPK.hashCode());
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
		if (CategoriaPK == null) {
			if (other.CategoriaPK != null)
				return false;
		} else if (!CategoriaPK.equals(other.CategoriaPK))
			return false;
		return true;
	}
	
	

}
