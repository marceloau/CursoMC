package com.aurino.cursoau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurino.cursoau.dominio.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
	
	@Transactional(readOnly=true)
	public Cliente findByEmail(final String email);
	
	@Transactional(readOnly=true)
	public Cliente findBycpfCNPJ(String cpfCNPJ);

}
