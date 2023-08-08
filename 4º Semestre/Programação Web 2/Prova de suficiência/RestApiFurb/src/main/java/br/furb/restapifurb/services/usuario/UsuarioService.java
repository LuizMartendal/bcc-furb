package br.furb.restapifurb.services.usuario;

import br.furb.restapifurb.exceptions.runtime.BadRequestException;
import br.furb.restapifurb.models.comanda.Comanda;
import br.furb.restapifurb.models.usuario.Usuario;
import br.furb.restapifurb.repositories.usuario.UsuarioRepository;
import br.furb.restapifurb.services.ServiceImpl;
import br.furb.restapifurb.services.comanda.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends ServiceImpl<Usuario> implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ComandaService comandaService;

    @Override
    public JpaRepository<Usuario, Long> getRepository() {
        return repository;
    }

    @Override
    public Usuario create(Usuario entity) {
        if (repository.findByUsuario(entity.getUsuario()).isPresent()) {
            throw new BadRequestException("Nome de usuário já utilizado");
        }
        entity.setSenha(new BCryptPasswordEncoder().encode(entity.getSenha()));
        return super.create(entity);
    }

    @Override
    public void delete(Long id) {
        List<Comanda> comandas = comandaService.findAllComandasByUsuario(id);
        if (comandas.size() > 0) {
            comandaService.deleteAll(comandas);
        }
        super.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByUsuario(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
        }
        return User
                .builder()
                    .username(usuario.get().getUsuario())
                    .password(usuario.get().getSenha())
                    .roles(usuario.get().getRole().toString())
                .build();
    }


}
