package com.aurino.cursoau.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.facade.ProdutoFacade;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoFacade produtoFacade;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long id) {
		
		final Produto cliente = produtoFacade.buscarPorCodigo(id);
		
		return ResponseEntity.ok().body(cliente);
	}

}
