package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long> {

}
