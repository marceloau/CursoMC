/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Estado;
import com.aurino.cursoau.type.EstadoType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class EstadoTypeConverter {

	/**
	 * 
	 */
	public EstadoTypeConverter() {
	}
	
	public EstadoType converterParaType(final Estado estado) {
		EstadoType estadoType = null;
		if(estado != null) {
			estadoType = new EstadoType();
			estadoType.setCodigoEstado(estado.getId());
			estadoType.setNome(estado.getNome());
		}
		return estadoType;
	}
	
	public Estado converterParaEntidade(final EstadoType estadoType) {
		Estado estado = null;
		if(estadoType != null) {
			estado = new Estado();
			estado.setId(estadoType.getCodigoEstado());
			estado.setNome(estadoType.getNome());
		}
		return estado;
	}
	
	public List<EstadoType> converterParaListaType(final List<Estado> listaEstados){
		List<EstadoType> listaEstadosRetorno;
		if(Utils.listaVaziaOuNula(listaEstados)) {
			listaEstadosRetorno = null;
		}else{
			listaEstadosRetorno = new ArrayList<>();
			for(final Estado estado : listaEstados){
				listaEstadosRetorno.add(this.converterParaType(estado));
						
			}
		}
		return listaEstadosRetorno;
	}
}
