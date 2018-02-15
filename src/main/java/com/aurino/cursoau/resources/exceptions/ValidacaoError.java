/**
 * 
 */
package com.aurino.cursoau.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marcelo.aurino
 *
 */
public class ValidacaoError extends ErrorPadrao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CamposMensagem> erros = new ArrayList<>();
	
	/**
	 * @param status
	 * @param msg
	 * @param timeStamp
	 */
	public ValidacaoError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
 	}

	/**
	 * @return the erros
	 */
	public List<CamposMensagem> getErros() {
		return erros;
	}

	public void adicionarErro(final String nomeCampo, final String mensagem) {
		erros.add(new CamposMensagem(nomeCampo, mensagem));
	}

}
