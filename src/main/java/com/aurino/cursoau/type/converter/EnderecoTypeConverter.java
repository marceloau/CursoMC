/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Endereco;
import com.aurino.cursoau.type.EnderecoType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class EnderecoTypeConverter {

	@Autowired
	private CidadeTypeConverter cidadeTypeConverter;
	
	/**
	 * 
	 */
	public EnderecoTypeConverter() {
	}
	
	public EnderecoType converterParaType(final Endereco endereco) {
		EnderecoType enderecoType = null;
		if(endereco != null) {
			enderecoType = new EnderecoType();
			enderecoType.setCodigoEndereco(endereco.getId());
			enderecoType.setLogradouro(endereco.getLogradouro());
			enderecoType.setNumero(endereco.getNumero());
			enderecoType.setComplemento(endereco.getComplemento());
			enderecoType.setBairro(endereco.getBairro());
			enderecoType.setCidade(cidadeTypeConverter.converterParaType(endereco.getCidade()));
			enderecoType.setCep(endereco.getCep());
		}
		return enderecoType;
	}
	
	public Endereco converterParaEntidade(final EnderecoType enderecoType) {
		Endereco endereco = null;
		if(enderecoType != null) {
			endereco = new Endereco();
			endereco.setId(enderecoType.getCodigoEndereco());
			endereco.setLogradouro(enderecoType.getLogradouro());
			endereco.setNumero(enderecoType.getNumero());
			endereco.setComplemento(enderecoType.getComplemento());
			endereco.setBairro(enderecoType.getBairro());
			endereco.setCidade(cidadeTypeConverter.converterParaEntidade(enderecoType.getCidade()));
			endereco.setCep(enderecoType.getCep());
		}
		return endereco;
	}
	
	public List<EnderecoType> converterParaListaType(final List<Endereco> listaEnderecos){
		List<EnderecoType> listaEnderecosRetorno;
		if(Utils.listaVaziaOuNula(listaEnderecos)) {
			listaEnderecosRetorno = null;
		}else{
			listaEnderecosRetorno = new ArrayList<>();
			for(final Endereco endereco : listaEnderecos){
				listaEnderecosRetorno.add(this.converterParaType(endereco));
						
			}
		}
		return listaEnderecosRetorno;
	}
	
	public List<Endereco> converterParaListaEntidade(final List<EnderecoType> listaEnderecos){
		List<Endereco> listaEnderecosRetorno;
		if(Utils.listaVaziaOuNula(listaEnderecos)) {
			listaEnderecosRetorno = null;
		}else{
			listaEnderecosRetorno = new ArrayList<>();
			for(final EnderecoType endereco : listaEnderecos){
				listaEnderecosRetorno.add(this.converterParaEntidade(endereco));
						
			}
		}
		return listaEnderecosRetorno;
	}
}
