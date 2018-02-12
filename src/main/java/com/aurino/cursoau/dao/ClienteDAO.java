package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
