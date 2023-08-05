package br.furb.restapifurb.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class ServiceImpl<T> implements Service<T> {

    public abstract JpaRepository<T, Long> getRepository();

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
