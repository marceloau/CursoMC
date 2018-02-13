package com.aurino.cursoau.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.serviceInterface.IProdutoBusiness;

@Component
public class ProdutoFacade {
	
	@Autowired
	private IProdutoBusiness iProdutoBusiness;
	
	public Produto buscarPorCodigo(final Long codigoProduto) {
		
		final Produto produto = iProdutoBusiness.buscarPorCodigo(codigoProduto);
		
		return produto;
		
	}

}
