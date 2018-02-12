package com.aurino.cursoau.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long> {

}
