package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Estado;

@Repository
public interface EstadoDAO extends JpaRepository<Estado, Long> {

}
