/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Cidade;
import com.aurino.cursoau.type.CidadeType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class CidadeTypeConverter {

	@Autowired
	private EstadoTypeConverter estadoTypeConverter;
	
	/**
	 * 
	 */
	public CidadeTypeConverter() {
	}
	
	public CidadeType converterParaType(final Cidade cidade) {
		CidadeType cidadeType = null;
		if(cidade != null) {
			cidadeType = new CidadeType();
			cidadeType.setCodigoCidade(cidade.getId());
			cidadeType.setNome(cidade.getNome());
			cidadeType.setEstado(estadoTypeConverter.converterParaType(cidade.getEstado()));
		}
		return cidadeType;
	}
	
	public Cidade converterParaEntidade(final CidadeType cidadeType) {
		Cidade cidade = null;
		if(cidadeType != null) {
			cidade = new Cidade();
			cidade.setId(cidadeType.getCodigoCidade());
			cidade.setNome(cidadeType.getNome());
			cidade.setEstado(estadoTypeConverter.converterParaEntidade(cidadeType.getEstado()));
		}
		return cidade;
	}
	
	public List<CidadeType> converterParaListaType(final List<Cidade> listaCidades){
		List<CidadeType> listaCidadesRetorno;
		if(Utils.listaVaziaOuNula(listaCidades)) {
			listaCidadesRetorno = null;
		}else{
			listaCidadesRetorno = new ArrayList<>();
			for(final Cidade cidade : listaCidades){
				listaCidadesRetorno.add(this.converterParaType(cidade));
						
			}
		}
		return listaCidadesRetorno;
	}
}
