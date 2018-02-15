package com.aurino.cursoau.serviceInterface;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Categoria;

@Component
public interface ICategoriaBusiness {

	public Categoria buscarPorCodigo(final Long codigoCategoria);
	
	public Categoria salvar(final Categoria categoria);
	
	public Categoria atualizar(final Long codigoCategoria, final Categoria categoria);
	
	public void excluir(final Long codigoCategoria);
	
}
