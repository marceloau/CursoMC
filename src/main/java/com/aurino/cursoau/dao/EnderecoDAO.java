package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Endereco;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Long> {

}
