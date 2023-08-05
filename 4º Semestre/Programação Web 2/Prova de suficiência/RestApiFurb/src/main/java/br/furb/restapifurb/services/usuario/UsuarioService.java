package br.furb.restapifurb.services.usuario;

import br.furb.restapifurb.models.usuario.Usuario;
import br.furb.restapifurb.repositories.usuario.UsuarioRepository;
import br.furb.restapifurb.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends ServiceImpl<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public JpaRepository<Usuario, Long> getRepository() {
        return repository;
    }
}
