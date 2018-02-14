package com.aurino.cursoau.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.dominio.Pedido;
import com.aurino.cursoau.facade.PedidoFacade;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoFacade pedidoFacade;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> buscarPorCodigo(@PathVariable Long id) {
		
		final Pedido pedido = pedidoFacade.buscarPorCodigo(id);
		
		return ResponseEntity.ok().body(pedido);
	}

}
