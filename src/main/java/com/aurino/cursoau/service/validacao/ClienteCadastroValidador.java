/**
 * 
 */
package com.aurino.cursoau.service.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.aurino.cursoau.comum.DocumentoUtil;
import com.aurino.cursoau.dao.ClienteDAO;
import com.aurino.cursoau.dominio.Cliente;
import com.aurino.cursoau.resources.exceptions.CamposMensagem;
import com.aurino.cursoau.type.ClienteType;

/**
 * @author marcelo.aurino
 *
 */
public class ClienteCadastroValidador implements ConstraintValidator<ClienteCadastro, ClienteType> {

	private static final Integer TIPO_PESSOA_FISICA = 1;
	private static final Integer TIPO_PESSOA_JURIDICA = 2;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public void initialize(ClienteCadastro ann) {
	}

	@Override
	public boolean isValid(ClienteType objType, ConstraintValidatorContext context) {
		List<CamposMensagem> list = new ArrayList<>();

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		if(map.get("id") == null) {
			if(objType.getCodigoTipoCliente() == null) {
				list.add(new CamposMensagem("codigoTipoCliente", "Tipo do cliente não pode ser nulo."));
			}
			
			if(objType.getCodigoTipoCliente() != null) { 
					
				if(objType.getCodigoTipoCliente().equals(TIPO_PESSOA_FISICA)
					&& !DocumentoUtil.isValidCPF(objType.getCpfCNPJ())) {
					list.add(new CamposMensagem("cpfCNPJ", "CPF inválido."));
				}else if(objType.getCodigoTipoCliente().equals(TIPO_PESSOA_JURIDICA)
					&& !DocumentoUtil.isValidCNPJ(objType.getCpfCNPJ())) {
					list.add(new CamposMensagem("cpfCNPJ", "CNPJ inválido."));
				}
				
				final Cliente clienteCPFCNPJ = clienteDAO.findBycpfCNPJ(objType.getCpfCNPJ());
				if(objType.getCodigoTipoCliente() == TIPO_PESSOA_FISICA
						&& clienteCPFCNPJ != null) {
					list.add(new CamposMensagem("cpfCNPJ", "CPF Já cadastrado."));
				}else if(objType.getCodigoTipoCliente().equals(TIPO_PESSOA_JURIDICA)
						&& clienteCPFCNPJ!= null) {
					list.add(new CamposMensagem("cpfCNPJ", "CNPJ Já cadastrado."));
				}
			}	
			
			final Cliente cliente = clienteDAO.findByEmail(objType.getEmail());
			
			if(cliente != null) {
				list.add(new CamposMensagem("email", "Email já cadastrado."));
			}
		}
		
		for (CamposMensagem e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
