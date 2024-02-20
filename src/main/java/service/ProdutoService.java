package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.IProdutoDAO;
import domain.Produto;
import service.generic.GenericService;

@Stateless
public class ProdutoService extends GenericService < Produto, String > implements IProdutoService {

  @Inject
  public ProdutoService(IProdutoDAO dao) {
    super(dao);
  }

  @Override
  public Produto buscarPorCodigo(String codigo) {
    try {
      return this.dao.consultar(codigo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}