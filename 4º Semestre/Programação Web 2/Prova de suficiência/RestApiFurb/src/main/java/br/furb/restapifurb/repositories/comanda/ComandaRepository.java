package br.furb.restapifurb.repositories.comanda;

import br.furb.restapifurb.models.comanda.Comanda;
import br.furb.restapifurb.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    List<Comanda> findAllByUsuario(Usuario usuario);
}
