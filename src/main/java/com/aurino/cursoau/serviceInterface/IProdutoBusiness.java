package com.aurino.cursoau.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Produto;

@Component
public interface IProdutoBusiness {

	public Produto buscarPorCodigo(final Long codigoProduto);
	
	public Page<Produto> buscarPorNomeECategorias(final String nome, final List<Long> codigosCategoria,
			final Integer page, final Integer size, final String orderBy, final String direcao);
	
}
