package com.aurino.cursoau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IProdutoBusiness;

@Service
public class ProdutoBusiness implements IProdutoBusiness {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Override
	public Produto buscarPorCodigo(final Long codigoProduto) {
		
		final Produto produto = produtoDAO.findOne(codigoProduto);
		
		if(produto == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoProduto + ", Tipo: " + Produto.class.getName());
		}
		
		return produto;
		
	}
	
}
