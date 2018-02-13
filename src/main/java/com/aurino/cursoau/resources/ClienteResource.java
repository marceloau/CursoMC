package com.aurino.cursoau.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.facade.ClienteFacade;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteFacade clienteFacade;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long id) {
		
		final Cliente cliente = clienteFacade.buscarPorCodigo(id);
		
		return ResponseEntity.ok().body(cliente);
	}

}
