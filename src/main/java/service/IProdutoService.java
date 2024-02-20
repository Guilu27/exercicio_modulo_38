package service;

import domain.Produto;
import service.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String>{

	Produto buscarPorCodigo(String codigo);
}
