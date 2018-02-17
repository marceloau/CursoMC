package com.aurino.cursoau.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dao.CidadeDAO;
import com.aurino.cursoau.dao.ClienteDAO;
import com.aurino.cursoau.dao.EnderecoDAO;
import com.aurino.cursoau.dominio.Cidade;
import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.dominio.Endereco;
import com.aurino.cursoau.service.exceptions.BusinessException;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IClienteBusiness;

@Service
public class ClienteBusiness implements IClienteBusiness {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private CidadeDAO cidadeDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Override
	public Cliente buscarPorCodigo(final Long codigoCliente) {
		final Cliente cliente = clienteDAO.findOne(codigoCliente);
		if(cliente == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoCliente + ", Tipo: " + Cliente.class.getName());
		}
		return cliente;
	}
	
	@Override
	public Cliente salvar(final Cliente cliente) {
		cliente.setId(null);
		if(!Utils.listaVaziaOuNula(cliente.getEnderecos())) {
			final List<Endereco> listaEnderecos = new ArrayList<>();
			for(final Endereco endereco : cliente.getEnderecos()) {
				if(endereco.getCidade() == null) {
					throw new BusinessException(MensagensException.ENDERECO_SEM_CIDADE.getValue());
				}
				final Cidade cidade = cidadeDAO.findOne(endereco.getCidade().getId());
				endereco.setCidade(cidade);
				endereco.setCliente(cliente);
				listaEnderecos.add(endereco);
			}
			cliente.setEnderecos(listaEnderecos);
		}
		final Cliente clienteSalvo = clienteDAO.save(cliente);
		enderecoDAO.save(clienteSalvo.getEnderecos());
		return clienteSalvo;
	}
	
	@Override
	public Cliente atualizar(final Long codigoCliente, final Cliente cliente) {
		this.buscarPorCodigo(codigoCliente);
		final Cliente novoCliente = buscarPorCodigo(codigoCliente);
		atualizarDadosCliente(novoCliente, cliente);
		return clienteDAO.save(novoCliente);
	}
	
	@Override
	public void excluir(final Long codigoCliente) {
		final Cliente cliente = buscarPorCodigo(codigoCliente);
		// Não é permitido excluir um cliente que possua pedidos associados ao mesmo.
		if(!Utils.listaVaziaOuNula(cliente.getPedidos())) {
			throw new BusinessException(MensagensException.CLIENTE_COM_PEDIDOS.getValue());
		}
		clienteDAO.delete(codigoCliente);
	}
	
	@Override
	public List<Cliente> listarTodos() {
		final List<Cliente> clientes = clienteDAO.findAll();
		return clientes;
	}
	
	public Page<Cliente> listarPorPagina(final Integer page, 
			final Integer size, final String orderBy, final String direcao){
		PageRequest pageRequest = new PageRequest(page, size, Direction.valueOf(direcao), orderBy);
		return clienteDAO.findAll(pageRequest);
	}
	
	private void atualizarDadosCliente(final Cliente novoCliente, final Cliente cliente) {
		novoCliente.setNome(cliente.getNome());
		novoCliente.setEmail(cliente.getEmail());
		novoCliente.setCpfCNPJ(cliente.getCpfCNPJ());
		novoCliente.setTipoCliente(cliente.getTipoCliente());
	}
	
}
