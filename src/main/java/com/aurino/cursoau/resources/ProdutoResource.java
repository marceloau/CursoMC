package com.aurino.cursoau.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.facade.ProdutoFacade;
import com.aurino.cursoau.type.ProdutoType;
import com.aurino.cursoau.type.converter.ProdutoTypeConverter;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoFacade produtoFacade;
	
	@Autowired
	private ProdutoTypeConverter produtoTypeConvert;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProdutoType> buscarPorCodigo(@PathVariable Long id) {
		
		final Produto produto = produtoFacade.buscarPorCodigo(id);
		final ProdutoType retorno = produtoTypeConvert.converterParaType(produto);
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoType>> buscarPorNomeECategorias(
			@RequestParam(value="nome" , defaultValue="") String nome,
			@RequestParam(value="categorias" , defaultValue="") String codigosCategoria,
			@RequestParam(value="page" , defaultValue="0") Integer page,
			@RequestParam(value="size" , defaultValue="10") Integer size, 
			@RequestParam(value="orderBy" , defaultValue="nome") String orderBy, 
			@RequestParam(value="direcao" , defaultValue="ASC") String direcao) {
		final List<Long> listaCodigoCategoria = Utils.converterEmListaLong(codigosCategoria, ",");
		final String nomeDecodificado = Utils.decodificarParametro(nome);
		final Page<Produto> produtos = produtoFacade.buscarPorNomeECategorias(nomeDecodificado, 
				listaCodigoCategoria, page, size, orderBy, direcao);
		final Page<ProdutoType> retorno = produtos.map(obj -> new ProdutoType(obj));
		return ResponseEntity.ok().body(retorno);
	}

}
