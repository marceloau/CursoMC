package com.aurino.cursoau.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Pedido;
import com.aurino.cursoau.serviceInterface.IPedidoBusiness;

@Component
public class PedidoFacade {
	
	@Autowired
	private IPedidoBusiness iPedidoBusiness;
	
	public Pedido buscarPorCodigo(final Long codigoPedido) {
		
		final Pedido pedido = iPedidoBusiness.buscarPorCodigo(codigoPedido);
		
		return pedido;
		
	}

}
