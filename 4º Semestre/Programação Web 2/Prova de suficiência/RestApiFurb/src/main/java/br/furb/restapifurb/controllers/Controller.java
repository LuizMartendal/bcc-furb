package br.furb.restapifurb.controllers;

import java.util.List;

public interface Controller<T> {

    T create(T entity);
    T update(T entity, Long id);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
}
