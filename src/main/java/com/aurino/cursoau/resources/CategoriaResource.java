package com.aurino.cursoau.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.facade.CategoriaFacade;
import com.aurino.cursoau.type.CategoriaType;
import com.aurino.cursoau.type.converter.CategoriaTypeConverter;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaFacade categoriaFacade;
	
	@Autowired
	private CategoriaTypeConverter categoriaTypeConvert;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<CategoriaType> buscarPorCodigo(@PathVariable Long id) {
		final Categoria categoria = categoriaFacade.buscarPorCodigo(id);
		final CategoriaType retorno = categoriaTypeConvert.converterParaType(categoria);
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody CategoriaType categoriaType){
		final Categoria categoria = categoriaFacade.salvar(
				categoriaTypeConvert.converterParaEntidade(categoriaType));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaType categoriaType){
		categoriaFacade.atualizar(
				id, categoriaTypeConvert.converterParaEntidade(categoriaType));
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		categoriaFacade.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaType>> listarTodos() {
		final List<Categoria> categorias = categoriaFacade.listarTodos();
		final List<CategoriaType> retorno = categoriaTypeConvert.converterParaListaType(categorias);
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(value="/pagina", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaType>> listarPorPagina(
			@RequestParam(value="page" , defaultValue="0") Integer page,
			@RequestParam(value="size" , defaultValue="10") Integer size, 
			@RequestParam(value="orderBy" , defaultValue="nome") String orderBy, 
			@RequestParam(value="direcao" , defaultValue="ASC") String direcao) {
		final Page<Categoria> categorias = categoriaFacade.listarPorPagina(page, size,orderBy, direcao);
		final Page<CategoriaType> retorno = categorias.map(obj -> new CategoriaType(obj));
		return ResponseEntity.ok().body(retorno);
	}

}
