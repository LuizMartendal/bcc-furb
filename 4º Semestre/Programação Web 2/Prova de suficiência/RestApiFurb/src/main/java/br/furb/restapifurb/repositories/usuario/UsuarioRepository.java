package br.furb.restapifurb.repositories.usuario;

import br.furb.restapifurb.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
