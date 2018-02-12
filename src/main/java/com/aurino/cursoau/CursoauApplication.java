package com.aurino.cursoau;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dao.CidadeDAO;
import com.aurino.cursoau.dao.EstadoDAO;
import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.dominio.Cidade;
import com.aurino.cursoau.dominio.Estado;
import com.aurino.cursoau.dominio.Produto;

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

	public static void main(String[] args) {
		SpringApplication.run(CursoauApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		final Categoria categoria1 = new Categoria(null, "Informática");
		final Categoria categoria2 = new Categoria(null, "Escritorio");
		
		final Produto produto1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00));
		final Produto produto2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00)); 
		final Produto produto3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00));
		
		//Relaciomento de Produtos com categorias
		categoria1.setProdutos(Arrays.asList(produto1, produto2, produto3));
		categoria2.setProdutos(Arrays.asList(produto2));
		
		//Relacionamento de categorias com produtos
		produto1.setCategorias(Arrays.asList(categoria1));
		produto2.setCategorias(Arrays.asList(categoria1,categoria2));
		produto3.setCategorias(Arrays.asList(categoria1));
		
		categoriaDAO.save(Arrays.asList(categoria1, categoria2));
		produtoDAO.save(Arrays.asList(produto1, produto2, produto3));
		
		final Estado estado1 = new Estado(null, "Minas Gerais");
		final Estado estado2 = new Estado(null, "São Paulo");
		
		final Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		final Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		final Cidade cidade3 = new Cidade(null, "Campinas", estado2);

		estado1.setCidades(Arrays.asList(cidade1));
		estado2.setCidades(Arrays.asList(cidade2, cidade3));
		
		estadoDAO.save(Arrays.asList(estado1, estado2));
		cidadeDAO.save(Arrays.asList(cidade1, cidade2, cidade3));
		
	}
}
