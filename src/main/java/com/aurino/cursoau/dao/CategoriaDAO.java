package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Long> {

}
