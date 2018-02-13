package com.aurino.cursoau.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.serviceInterface.IClienteBusiness;

@Component
public class ClienteFacade {
	
	@Autowired
	private IClienteBusiness iClienteBusiness;
	
	public Cliente buscarPorCodigo(final Long codigoCliente) {
		
		final Cliente cliente = iClienteBusiness.buscarPorCodigo(codigoCliente);
		
		return cliente;
		
	}

}
