package com.aurino.cursoau.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.dominio.Cliente;

@Component
public interface IClienteBusiness {

	public Cliente buscarPorCodigo(final Long codigoCliente);
	
	public Cliente salvar(final Cliente cliente);
	
	public Cliente atualizar(final Long codigoCliente, final Cliente cliente);
	
	public void excluir(final Long codigoCliente);
	
	public List<Cliente> listarTodos();
	
	public Page<Cliente> listarPorPagina(final Integer page, 
			final Integer size, final String orderBy, final String direcao);
	
}
