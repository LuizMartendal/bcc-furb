package br.furb.restapifurb.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller<T> {

    ResponseEntity<T> create(T entity);
    ResponseEntity<T> update(T entity, Long id);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<T> findById(Long id);
    ResponseEntity<?> delete(Long id);

}
