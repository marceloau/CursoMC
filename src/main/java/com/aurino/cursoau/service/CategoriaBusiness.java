package com.aurino.cursoau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.service.exceptions.BusinessException;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.ICategoriaBusiness;

@Service
public class CategoriaBusiness implements ICategoriaBusiness {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public Categoria buscarPorCodigo(final Long codigoCategoria) {
		
		final Categoria categoria = categoriaDAO.findOne(codigoCategoria);
		
		if(categoria == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoCategoria + ", Tipo: " + Categoria.class.getName());
		}
		
		return categoria;
		
	}
	
	@Override
	public Categoria salvar(final Categoria categoria) {
		categoria.setId(null);
		return categoriaDAO.save(categoria);
	}
	
	@Override
	public Categoria atualizar(final Long codigoCategoria, final Categoria categoria) {
		this.buscarPorCodigo(codigoCategoria);
		categoria.setId(codigoCategoria);
		return categoriaDAO.save(categoria);
	}
	
	@Override
	public void excluir(final Long codigoCategoria) {
		final Categoria categoria = this.buscarPorCodigo(codigoCategoria);

		// Não é permitido excluir uma categoria que possua produtos associados a mesma.
		if(!Utils.listaVaziaOuNula(categoria.getProdutos())) {
			throw new BusinessException(MensagensException.CATEGORIA_COM_PRODUTOS.getValue());
		}
		
		categoriaDAO.delete(codigoCategoria);
	}
}
