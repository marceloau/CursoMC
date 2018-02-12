package com.aurino.cursoau.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.serviceInterface.ICategoriaBusiness;

public class CategoriaFacade {
	
	@Autowired
	private ICategoriaBusiness iCategoriaBusiness;
	
	public Categoria buscarPorCodigo(final Integer codigoCategoria) {
		
		final Categoria categoria = iCategoriaBusiness.buscarPorCodigo(codigoCategoria);
		
		return categoria;
		
	}

}
