package com.aurino.cursoau.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.serviceInterface.IProdutoBusiness;

@Component
public class ProdutoFacade {
	
	@Autowired
	private IProdutoBusiness iProdutoBusiness;
	
	public Produto buscarPorCodigo(final Long codigoProduto) {
		return iProdutoBusiness.buscarPorCodigo(codigoProduto);
	}
	
	public Page<Produto> buscarPorNomeECategorias(final String nome, final List<Long> codigosCategoria,
			final Integer page, final Integer size, final String orderBy, final String direcao){
		return iProdutoBusiness.buscarPorNomeECategorias(nome, codigosCategoria, page, size, orderBy, direcao);
	}

}
