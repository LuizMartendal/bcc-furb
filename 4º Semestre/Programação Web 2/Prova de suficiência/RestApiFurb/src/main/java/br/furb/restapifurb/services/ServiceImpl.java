package br.furb.restapifurb.services;

import br.furb.restapifurb.exceptions.runtime.BadRequestException;
import br.furb.restapifurb.exceptions.runtime.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class ServiceImpl<T> implements Service<T> {

    public abstract JpaRepository<T, Long> getRepository();

    @Override
    public T create(T entity) {
        if (entity == null) {
            throw new BadRequestException("Entidade não pode ser núla");
        }
        return getRepository().save(entity);
    }

    @Override
    public T update(T entity, Long id) {
        if (entity == null) {
            throw new BadRequestException("Entidade não pode ser núla");
        }
        Optional<T> e = getRepository().findById(id);
        if (e.isPresent()) {
            return getRepository().save(entity);
        }
        throw new NotFoundException("Entidade não encontrada");
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(Long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new NotFoundException("Entidade com o id " + id + " não foi encontrada."));
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(
                getRepository().findById(id)
                        .orElseThrow(() -> new NotFoundException("Entidade não encontrada"))
        );
    }
}
