package com.aurino.cursoau;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurino.cursoau.dao.CategoriaDAO;
import com.aurino.cursoau.dao.ProdutoDAO;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.dominio.Produto;

@SpringBootApplication
public class CursoauApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;

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
	}
}
