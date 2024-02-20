package service.generic;

import java.io.Serializable;
import java.util.Collection;

import dao.generic.IGenericDAO;
import domain.Persistente;

public class GenericService < T extends Persistente, E extends Serializable >
  implements IGenericService < T, E > {

    protected IGenericDAO < T, E > dao;

    public GenericService(IGenericDAO < T, E > dao) {
      this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) {
      return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) {
      this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) {
      return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) {
      return this.dao.consultar(valor);
    }

    @Override
    public Collection < T > buscarTodos() {
      return this.dao.buscarTodos();
    }

  }