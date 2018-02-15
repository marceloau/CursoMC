package com.aurino.cursoau.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Categoria;

@Component
public interface ICategoriaBusiness {

	public Categoria buscarPorCodigo(final Long codigoCategoria);
	
	public Categoria salvar(final Categoria categoria);
	
	public Categoria atualizar(final Long codigoCategoria, final Categoria categoria);
	
	public void excluir(final Long codigoCategoria);
	
	public List<Categoria> listarTodos();
	
	public Page<Categoria> listarPorPagina(final Integer page, 
			final Integer size, final String orderBy, final String direcao);
	
}
