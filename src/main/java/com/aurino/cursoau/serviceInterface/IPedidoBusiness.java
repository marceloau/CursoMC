package com.aurino.cursoau.serviceInterface;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Pedido;

@Component
public interface IPedidoBusiness {

	public Pedido buscarPorCodigo(final Long codigoPedido);
	
	/**
	 * Método para criar o pedido no banco de dados
	 *
	 * @param pedido
	 * @return
	 */
	public Pedido salvar(final Pedido pedido);
	
}
