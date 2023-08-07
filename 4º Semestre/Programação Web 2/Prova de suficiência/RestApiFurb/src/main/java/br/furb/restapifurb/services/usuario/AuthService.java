package br.furb.restapifurb.services.usuario;

import br.furb.restapifurb.dtos.CredenciaisDTO;
import br.furb.restapifurb.dtos.TokenDTO;
import br.furb.restapifurb.models.usuario.Usuario;
import br.furb.restapifurb.repositories.usuario.UsuarioRepository;
import br.furb.restapifurb.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public TokenDTO signin(CredenciaisDTO data) {
        try {
            String username = data.getUsuario();
            String password = data.getSenha();

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            Optional<Usuario> user = repository.findByUsuario(username);

            if (user.isPresent()) {
                return tokenProvider.criarTokenDeAcesso(username, user.get().getRole());
            } else {
                throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
            }
        } catch (Exception e) {
            throw new BadCredentialsException("Usuário ou senha incorretos!");
        }
    }
}
