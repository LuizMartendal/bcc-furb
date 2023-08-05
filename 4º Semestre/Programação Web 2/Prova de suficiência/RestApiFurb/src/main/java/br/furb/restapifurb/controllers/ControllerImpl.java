package br.furb.restapifurb.controllers;

import br.furb.restapifurb.services.Service;

import java.util.List;

public abstract class ControllerImpl<T> implements Controller<T> {

    public abstract Service<T> getService();

    @Override
    public T create(T entity) {
        return null;
    }

    @Override
    public T update(T entity, Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
