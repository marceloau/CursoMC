package com.aurino.cursoau.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.facade.ClienteFacade;
import com.aurino.cursoau.type.ClienteType;
import com.aurino.cursoau.type.converter.ClienteTypeConverter;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteFacade clienteFacade;
	
	@Autowired
	private ClienteTypeConverter clienteTypeConvert;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPorCodigo(@PathVariable Long id) {
		
		final Cliente cliente = clienteFacade.buscarPorCodigo(id);
		
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteType clienteType){
		clienteFacade.atualizar(
				id, clienteTypeConvert.converterParaEntidade(clienteType));
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteFacade.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteType>> listarTodos() {
		final List<Cliente> clientes = clienteFacade.listarTodos();
		final List<ClienteType> retorno = clienteTypeConvert.converterParaListaType(clientes);
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(value="/pagina", method=RequestMethod.GET)
	public ResponseEntity<Page<ClienteType>> listarPorPagina(
			@RequestParam(value="page" , defaultValue="0") Integer page,
			@RequestParam(value="size" , defaultValue="10") Integer size, 
			@RequestParam(value="orderBy" , defaultValue="nome") String orderBy, 
			@RequestParam(value="direcao" , defaultValue="ASC") String direcao) {
		final Page<Cliente> clientes = clienteFacade.listarPorPagina(page, size,orderBy, direcao);
		final Page<ClienteType> retorno = clientes.map(obj -> new ClienteType(obj));
		return ResponseEntity.ok().body(retorno);
	}
}
