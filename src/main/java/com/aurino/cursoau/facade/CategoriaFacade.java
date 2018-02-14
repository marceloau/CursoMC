package com.aurino.cursoau.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.serviceInterface.ICategoriaBusiness;

@Component
public class CategoriaFacade {
	
	@Autowired
	private ICategoriaBusiness iCategoriaBusiness;
	
	public Categoria buscarPorCodigo(final Long codigoCategoria) {
		
		final Categoria categoria = iCategoriaBusiness.buscarPorCodigo(codigoCategoria);
		
		return categoria;
		
	}
	
	public Categoria salvar(final Categoria categoria) {
		return iCategoriaBusiness.salvar(categoria);
	}

}
