/**
 * 
 */
package com.aurino.cursoau.comum;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author marcelo.aurino
 *
 */
public final class Utils {

	/**
	 * 
	 */
	public Utils() {
	}
	
	public static boolean listaVaziaOuNula(Collection<?> lista) {
		boolean retorno = false;
		
		if(lista == null) {
			retorno = true;
		}else if(lista.isEmpty()){
			retorno = true;
		}
		
		return retorno;
	}
	
	public static List<Long> converterEmListaLong(final String texto, final String separador){
		String[] listaValores = texto.split(separador);
		final List<Long> retorno = new ArrayList<>();
		for(final String valor : listaValores) {
			retorno.add(Long.valueOf(valor));
		}
		return retorno;
	}
	
	public static String decodificarParametro(final String parametro) {
		try {
			return URLDecoder.decode(parametro, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
