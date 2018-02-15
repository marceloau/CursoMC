/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.type.ProdutoType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class ProdutoTypeConverter {

	/**
	 * 
	 */
	public ProdutoTypeConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoType converterParaType(final Produto produto) {
		ProdutoType produtoType = null;
		if(produto != null) {
			produtoType = new ProdutoType();
			produtoType.setCodigoProduto(produto.getId());
			produtoType.setNome(produto.getNome());
			produtoType.setPreco(produto.getPreco());
		}
		return produtoType;
	}
	
	public List<ProdutoType> converterParaListaType(final List<Produto> listaProdutos){
		List<ProdutoType> listaProdutosRetorno;
		if(Utils.listaVaziaOuNula(listaProdutos)) {
			listaProdutosRetorno = null;
		}else{
			listaProdutosRetorno = new ArrayList<>();
			for(final Produto produto : listaProdutos){
				listaProdutosRetorno.add(this.converterParaType(produto));
						
			}
		}
		return listaProdutosRetorno;
	}

}
