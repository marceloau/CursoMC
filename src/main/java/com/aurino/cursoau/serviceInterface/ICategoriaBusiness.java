package com.aurino.cursoau.serviceInterface;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Categoria;

@Component
public interface ICategoriaBusiness {

	public Categoria buscarPorCodigo(final Integer codigoCategoria);
	
}
