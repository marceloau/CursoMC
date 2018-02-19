package com.aurino.cursoau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IProdutoBusiness;

@Service
public class ProdutoBusiness implements IProdutoBusiness {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public Produto buscarPorCodigo(final Long codigoProduto) {
		
		final Produto produto = produtoDAO.findOne(codigoProduto);
		
		if(produto == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoProduto + ", Tipo: " + Produto.class.getName());
		}
		
		return produto;
		
	}
	
	@Override
	public Page<Produto> buscarPorNomeECategorias(final String nome, final List<Long> codigosCategoria,
			final Integer page, final Integer size, final String orderBy, final String direcao){
		PageRequest pageRequest = new PageRequest(page, size, Direction.valueOf(direcao), orderBy);
		List<Categoria> categorias = categoriaDAO.findAll(codigosCategoria);
		return produtoDAO.buscarPorNomeECategorias(nome, categorias, pageRequest);
	}	
	
}
