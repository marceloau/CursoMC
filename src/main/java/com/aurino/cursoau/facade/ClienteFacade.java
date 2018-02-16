package com.aurino.cursoau.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	public Cliente salvar(final Cliente cliente) {
		return iClienteBusiness.salvar(cliente);
	}
	
	public Cliente atualizar(final Long codigoCliente, final Cliente cliente) {
		return iClienteBusiness.atualizar(codigoCliente, cliente);
	}
	
	public void excluir(final Long codigoCliente) {
		iClienteBusiness.excluir(codigoCliente);
	}
	
	public List<Cliente> listarTodos() {
		final List<Cliente> clientes = iClienteBusiness.listarTodos();
		return clientes;
	}
	
	public Page<Cliente> listarPorPagina(final Integer page, 
			final Integer size, final String orderBy, final String direcao) {
		final Page<Cliente> clientes = iClienteBusiness
				.listarPorPagina(page, size, orderBy, direcao);
		return clientes;
	}

}
