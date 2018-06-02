package com.aurino.cursoau;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dao.CidadeDAO;
import com.aurino.cursoau.dao.ClienteDAO;
import com.aurino.cursoau.dao.EnderecoDAO;
import com.aurino.cursoau.dao.EstadoDAO;
import com.aurino.cursoau.dao.ItemPedidoDAO;
import com.aurino.cursoau.dao.PagamentoDAO;
import com.aurino.cursoau.dao.PedidoDAO;
import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.dominio.Cidade;
import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.dominio.Contato;
import com.aurino.cursoau.dominio.Endereco;
import com.aurino.cursoau.dominio.Estado;
import com.aurino.cursoau.dominio.ItemPedido;
import com.aurino.cursoau.dominio.Pagamento;
import com.aurino.cursoau.dominio.PagamentoBoleto;
import com.aurino.cursoau.dominio.PagamentoCartao;
import com.aurino.cursoau.dominio.Pedido;
import com.aurino.cursoau.dominio.Produto;
import com.aurino.cursoau.enums.StatusPagamento;
import com.aurino.cursoau.enums.TipoCliente;

@SpringBootApplication
public class CursoauApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@Autowired
	private CidadeDAO cidadeDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private PagamentoDAO pagamentoDAO;
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;

	public static void main(String[] args) {
		SpringApplication.run(CursoauApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		final Categoria categoria1 = new Categoria(null, "Informática");
//		final Categoria categoria2 = new Categoria(null, "Escritorio");
//		
//		final Produto produto1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00));
//		final Produto produto2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00)); 
//		final Produto produto3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00));
//		
//		//Relaciomento de Produtos com categorias
//		categoria1.setProdutos(Arrays.asList(produto1, produto2, produto3));
//		categoria2.setProdutos(Arrays.asList(produto2));
//		
//		//Relacionamento de categorias com produtos
//		produto1.setCategorias(Arrays.asList(categoria1));
//		produto2.setCategorias(Arrays.asList(categoria1,categoria2));
//		produto3.setCategorias(Arrays.asList(categoria1));
//		
//		categoriaDAO.save(Arrays.asList(categoria1, categoria2));
//		produtoDAO.save(Arrays.asList(produto1, produto2, produto3));
//		
//		final Estado estado1 = new Estado(null, "Minas Gerais");
//		final Estado estado2 = new Estado(null, "São Paulo");
//		
//		final Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
//		final Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
//		final Cidade cidade3 = new Cidade(null, "Campinas", estado2);
//
//		estado1.setCidades(Arrays.asList(cidade1));
//		estado2.setCidades(Arrays.asList(cidade2, cidade3));
//		
//		estadoDAO.save(Arrays.asList(estado1, estado2));
//		cidadeDAO.save(Arrays.asList(cidade1, cidade2, cidade3));
//		
//		final Cliente cliente1 = new Cliente(null, "Marcelo Aurino", "marceloaurino2207@gmail.com", "09566409400", TipoCliente.PESSOAFISICA);
//		
//		final Contato contato1 = new Contato("nome", "35421321", 1);
//		final Contato contato2 = new Contato("nome", "997559668", 2);
//		
//		cliente1.setContatos(new HashSet<>(Arrays.asList(contato1, contato2)));
//		
//		final Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto. 303", "Jardim", "38220834", cliente1, cidade1);
//		final Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "53510330", cliente1, cidade2);
//		
//		cliente1.setEnderecos(Arrays.asList(endereco1, endereco2));
//		
//		clienteDAO.save(cliente1);
//		enderecoDAO.save(Arrays.asList(endereco1, endereco2));
//		
//		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
//		
//		final Pedido pedido1 = new Pedido(null, sdf.parse("10/02/2017 11:36"), cliente1, endereco1);
//		final Pedido pedido2 = new Pedido(null, sdf.parse("13/02/2017 10:06"), cliente1, endereco2);
//		
//		final Pagamento pagamento1 = new PagamentoCartao(null, StatusPagamento.QUITADO, pedido1, 6);
//		pedido1.setPagamento(pagamento1);
//		
//		final Pagamento pagamento2 = new PagamentoBoleto(null, StatusPagamento.PENDENTE, pedido2, sdf.parse("20/02/2017 00:00"), null); 
//		pedido2.setPagamento(pagamento2);
//		
//		cliente1.setPedidos(Arrays.asList(pedido1, pedido2));
//		
//		pedidoDAO.save(Arrays.asList(pedido1, pedido2));
//		pagamentoDAO.save(Arrays.asList(pagamento1, pagamento2));
//		
//		final ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, BigDecimal.valueOf(0.00), 1, BigDecimal.valueOf(2000.00));
//		final ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, BigDecimal.valueOf(0.00), 2, BigDecimal.valueOf(80.00));
//		final ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, BigDecimal.valueOf(100.00), 1, BigDecimal.valueOf(800.00));
//		
//		pedido1.setItens(Arrays.asList(itemPedido1, itemPedido2));
//		pedido2.setItens(Arrays.asList(itemPedido3));
//		
//		produto1.setItens(Arrays.asList(itemPedido1));
//		produto2.setItens(Arrays.asList(itemPedido3));
//		produto3.setItens(Arrays.asList(itemPedido2));
//		
//		itemPedidoDAO.save(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
}
