package com.aurino.cursoau.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.dominio.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long> {
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT produto "
			+ "FROM Produto produto "
			+ "INNER JOIN produto.categorias cat "
			+ "WHERE produto.nome like %:nome% "
			+ "AND cat IN :categorias")
	public Page<Produto> buscarPorNomeECategorias(@Param("nome") final String nome, 
			@Param("categorias") final List<Categoria> categorias, Pageable pageRequest);
	
}
