package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.ItemPedido;
import com.aurino.cursoau.dominio.ItemPedidoPK;

@Repository
public interface ItemPedidoDAO extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
