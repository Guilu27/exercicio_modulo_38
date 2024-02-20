package dao.generic;

import java.io.Serializable;
import java.util.Collection;

import domain.Persistente;

public interface IGenericDAO<T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity);

    public void excluir(T entity);

    public T alterar(T entity);
  
    public T consultar(E valor);

    public Collection<T> buscarTodos();

}
