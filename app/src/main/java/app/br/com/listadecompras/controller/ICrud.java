package app.br.com.listadecompras.controller;

import java.util.List;

public interface ICrud<T> {

    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);
    public void deleteByID(T obj);
    public List<T> listar(T obj);
}
