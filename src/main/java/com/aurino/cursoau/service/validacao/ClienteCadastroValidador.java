/**
 * 
 */
package com.aurino.cursoau.service.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aurino.cursoau.comum.DocumentoUtil;
import com.aurino.cursoau.resources.exceptions.CamposMensagem;
import com.aurino.cursoau.type.ClienteType;

/**
 * @author marcelo.aurino
 *
 */
public class ClienteCadastroValidador implements ConstraintValidator<ClienteCadastro, ClienteType> {

	private static final Integer TIPO_PESSOA_FISICA = 1;
	private static final Integer TIPO_PESSOA_JURIDICA = 2;	
	
	@Override
	public void initialize(ClienteCadastro ann) {
	}

	@Override
	public boolean isValid(ClienteType objType, ConstraintValidatorContext context) {
		List<CamposMensagem> list = new ArrayList<>();

		if(objType.getCodigoTipoCliente() == null) {
			list.add(new CamposMensagem("codigoTipoCliente", "Tipo do cliente não pode ser nulo."));
		}
		
		if(objType.getCodigoTipoCliente() != null 
				&& objType.getCodigoTipoCliente() == TIPO_PESSOA_FISICA
				&& !DocumentoUtil.isValidCPF(objType.getCpfCNPJ())) {
			list.add(new CamposMensagem("cpfCNPJ", "CPF inválido."));
		}
		
		if(objType.getCodigoTipoCliente() != null 
				&& objType.getCodigoTipoCliente() == TIPO_PESSOA_JURIDICA
				&& !DocumentoUtil.isValidCNPJ(objType.getCpfCNPJ())) {
			list.add(new CamposMensagem("cpfCNPJ", "CNPJ inválido."));
		}

		for (CamposMensagem e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
