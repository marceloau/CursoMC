package com.aurino.cursoau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.ClienteDAO;
import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IClienteBusiness;

@Service
public class ClienteBusiness implements IClienteBusiness {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public Cliente buscarPorCodigo(final Long codigoCliente) {
		
		final Cliente cliente = clienteDAO.findOne(codigoCliente);
		
		if(cliente == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoCliente + ", Tipo: " + Cliente.class.getName());
		}
		
		return cliente;
		
	}
	
}
