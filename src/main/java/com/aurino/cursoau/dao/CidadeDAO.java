package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Cidade;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Long> {

}
