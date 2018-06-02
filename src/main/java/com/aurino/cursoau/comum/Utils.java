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

	/**
	 * Verifica se value é uma String null ou vazia.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNullOrEmpty(final String value) {
		return (value == null) || value.trim().equals("");
	}

	/**
	 * Verifica se value NÃO é uma String null ou vazia.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNotNullOrEmpty(final String value) {
		return (value != null) && !value.trim().equals("");
	}

	/**
	 * Verifica se value NÃO é um objeto null ou vazio.
	 *
	 * @param objeto
	 *            the objeto
	 * @return boolean - boolean
	 */
	public static boolean isNotNullOrEmpty(final Object objeto) {
		boolean retorno = Boolean.FALSE;
		if (objeto != null) {
			if (!objeto.toString().trim().equals("")) {
				retorno = Boolean.TRUE;
			}
		}
		return retorno;
	}

	/**
	 * Verifica se value NÃO é um Number null ou vazio.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNotNullOrEmpty(final Number value) {
		return (value != null) && (value.longValue() > 0);
	}

	/**
	 * Verifica se value é um Number null ou vazio.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNullOrEmpty(final Number value) {
		return !isNotNullOrEmpty(value);
	}

	/**
	 * Verifica se a Collection é null ou vazia.
	 *
	 * @param collection
	 *            - collection
	 * @return boolean - boolean
	 */
	public static boolean isEmptyList(final Collection<? extends Object> collection) {
		return (collection == null) || collection.isEmpty();
	}

	/**
	 * Verifica se a Collection não se encontra vazia.
	 *
	 * @param collection
	 *            - collection
	 * @return boolean - boolean
	 */
	public static boolean isNotEmptyList(final Collection<? extends Object> collection) {
		return !isEmptyList(collection);
	}

	/**
	 * Verifica se o Object é null.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNull(final Object value) {
		return value == null;
	}

	/**
	 * Verifica se o Object NÃO é null.
	 *
	 * @param value
	 *            - value
	 * @return boolean - boolean
	 */
	public static boolean isNotNull(final Object value) {
		return !isNull(value);
	}
}
