package com.aurino.cursoau.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.facade.CategoriaFacade;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaFacade categoriaFacade;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long id) {
		
		final Categoria categoria = categoriaFacade.buscarPorCodigo(id);
		
		return ResponseEntity.ok().body(categoria);
	}

}
