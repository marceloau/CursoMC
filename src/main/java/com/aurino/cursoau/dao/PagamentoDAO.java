package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurino.cursoau.dominio.Pagamento;

@Repository
public interface PagamentoDAO extends JpaRepository<Pagamento, Long> {

}
