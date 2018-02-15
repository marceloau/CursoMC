/**
 * 
 */
package com.aurino.cursoau.comum;

import java.util.Collection;

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
}
