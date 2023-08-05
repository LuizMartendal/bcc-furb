package br.furb.restapifurb.services;

import java.util.List;

public interface Service<T> {

    T create(T entity);
    T update(T entity, Long id);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);

}
