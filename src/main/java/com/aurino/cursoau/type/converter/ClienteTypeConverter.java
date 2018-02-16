/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.enums.TipoCliente;
import com.aurino.cursoau.type.ClienteType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class ClienteTypeConverter {

	/**
	 * 
	 */
	public ClienteTypeConverter() {
	}
	
	public ClienteType converterParaType(final Cliente cliente) {
		ClienteType clienteType = null;
		if(cliente != null) {
			clienteType = new ClienteType();
			clienteType.setCodigoCliente(cliente.getId());
			clienteType.setNome(cliente.getNome());
			clienteType.setEmail(cliente.getEmail());
			clienteType.setCpfCNPJ(cliente.getCpfCNPJ());
			clienteType.setCodigoTipoCliente(cliente.getCodigoTipoCliente());
		}
		return clienteType;
	}
	
	public Cliente converterParaEntidade(final ClienteType clienteType) {
		Cliente cliente = null;
		if(clienteType != null) {
			cliente = new Cliente();
			cliente.setId(clienteType.getCodigoCliente());
			cliente.setNome(clienteType.getNome());
			cliente.setEmail(clienteType.getEmail());
			cliente.setCpfCNPJ(clienteType.getCpfCNPJ());
			cliente.setTipoCliente(TipoCliente.toEnum(clienteType.getCodigoTipoCliente()));
		}
		return cliente;
	}
	
	public List<ClienteType> converterParaListaType(final List<Cliente> listaClientes){
		List<ClienteType> listaClientesRetorno;
		if(Utils.listaVaziaOuNula(listaClientes)) {
			listaClientesRetorno = null;
		}else{
			listaClientesRetorno = new ArrayList<>();
			for(final Cliente cliente : listaClientes){
				listaClientesRetorno.add(this.converterParaType(cliente));
						
			}
		}
		return listaClientesRetorno;
	}
}
