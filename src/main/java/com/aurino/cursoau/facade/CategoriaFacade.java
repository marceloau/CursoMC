package com.aurino.cursoau.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	public Categoria atualizar(final Long codigoCategoria, final Categoria categoria) {
		return iCategoriaBusiness.atualizar(codigoCategoria, categoria);
	}
	
	public void excluir(final Long codigoCategoria) {
		iCategoriaBusiness.excluir(codigoCategoria);
	}
	
	public List<Categoria> listarTodos() {
		final List<Categoria> categorias = iCategoriaBusiness.listarTodos();
		return categorias;
	}
	
	public Page<Categoria> listarPorPagina(final Integer page, 
			final Integer size, final String orderBy, final String direcao) {
		final Page<Categoria> categorias = iCategoriaBusiness
				.listarPorPagina(page, size, orderBy, direcao);
		return categorias;
	}

}
