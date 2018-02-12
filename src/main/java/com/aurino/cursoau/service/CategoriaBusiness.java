package com.aurino.cursoau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.serviceInterface.ICategoriaBusiness;

@Service
public class CategoriaBusiness implements ICategoriaBusiness {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public Categoria buscarPorCodigo(final Long codigoCategoria) {
		
		final Categoria categoria = categoriaDAO.findOne(codigoCategoria);
		
		return categoria;
		
	}
	
}
