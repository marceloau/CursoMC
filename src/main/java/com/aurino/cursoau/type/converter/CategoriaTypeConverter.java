/**
 * 
 */
package com.aurino.cursoau.type.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aurino.cursoau.comum.Utils;
import com.aurino.cursoau.dominio.Categoria;
import com.aurino.cursoau.type.CategoriaType;

/**
 * @author marcelo.aurino
 *
 */
@Component
public class CategoriaTypeConverter {

	/**
	 * 
	 */
	public CategoriaTypeConverter() {
	}
	
	public CategoriaType converterParaType(final Categoria categoria) {
		CategoriaType categoriaType = null;
		if(categoria != null) {
			categoriaType = new CategoriaType();
			categoriaType.setCodigoCategoria(categoria.getId());
			categoriaType.setNome(categoria.getNome());
		}
		return categoriaType;
	}
	
	public List<CategoriaType> converterParaListaType(final List<Categoria> listaCategorias){
		List<CategoriaType> listaCategoriasRetorno;
		if(Utils.listaVaziaOuNula(listaCategorias)) {
			listaCategoriasRetorno = null;
		}else{
			listaCategoriasRetorno = new ArrayList<>();
			for(final Categoria categoria : listaCategorias){
				listaCategoriasRetorno.add(this.converterParaType(categoria));
						
			}
		}
		return listaCategoriasRetorno;
	}
}
