package com.aurino.cursoau.serviceInterface;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Produto;

@Component
public interface IProdutoBusiness {

	public Produto buscarPorCodigo(final Long codigoProduto);
	
}
