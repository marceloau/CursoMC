package com.aurino.cursoau.serviceInterface;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Cliente;

@Component
public interface IClienteBusiness {

	public Cliente buscarPorCodigo(final Long codigoCliente);
	
}
