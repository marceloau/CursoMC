package com.aurino.cursoau.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurino.cursoau.dao.ClienteDAO;
import com.aurino.cursoau.dao.EnderecoDAO;
import com.aurino.cursoau.dao.ItemPedidoDAO;
import com.aurino.cursoau.dao.PagamentoDAO;
import com.aurino.cursoau.dao.PedidoDAO;
import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.ItemPedido;
import com.aurino.cursoau.dominio.Pedido;
import com.aurino.cursoau.enums.StatusPagamento;
import com.aurino.cursoau.service.exceptions.MensagensException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;
import com.aurino.cursoau.serviceInterface.IPedidoBusiness;

@Service
public class PedidoBusiness implements IPedidoBusiness {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private PagamentoDAO pagamentoDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public Pedido buscarPorCodigo(final Long codigoPedido) {
		
		final Pedido pedido = pedidoDAO.findOne(codigoPedido);
		
		if(pedido == null) {
			throw new ObjectNotFoundException(MensagensException.REGISTRO_NAO_ENCONTRADO.getValue()
					+ " Id: " + codigoPedido + ", Tipo: " + Pedido.class.getName());
		}
		
		return pedido;
		
	}
	@Override
	public Pedido salvar(final Pedido pedido) {
		pedido.setId(null);
		pedido.setDataPedido(new Date());
		pedido.getPagamento().setCodigoStatus(StatusPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		final Pedido pedidoSalvo = pedidoDAO.save(pedido);
		
		pedidoSalvo.setPagamento(pagamentoDAO.save(pedido.getPagamento()));
		//pedido.setCliente(clienteDAO.getOne(pedido.getCliente().getId()));
		//pedidoSalvo.setEnderecoEntrega(enderecoDAO.getOne(pedido.getEnderecoEntrega().getId()));
		
		for(final ItemPedido itemPedido : pedido.getItens()) {
			itemPedido.setDesconto(BigDecimal.ZERO);
			itemPedido.setPreco(produtoDAO.findOne(itemPedido.getProduto().getId()).getPreco());
			itemPedido.setPedido(pedido);
			itemPedido.setProduto(produtoDAO.findOne(itemPedido.getProduto().getId()));
		}
		
		itemPedidoDAO.save(pedido.getItens());
		
		return pedidoSalvo;
	}
	
}
