package com.aurino.cursoau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.PedidoDAO;
import com.aurino.cursoau.dominio.Pedido;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IPedidoBusiness;

@Service
public class PedidoBusiness implements IPedidoBusiness {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Override
	public Pedido buscarPorCodigo(final Long codigoPedido) {
		
		final Pedido pedido = pedidoDAO.findOne(codigoPedido);
		
		if(pedido == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoPedido + ", Tipo: " + Pedido.class.getName());
		}
		
		return pedido;
		
	}
	
}
