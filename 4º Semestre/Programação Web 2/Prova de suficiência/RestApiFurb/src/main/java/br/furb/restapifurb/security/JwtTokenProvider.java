package br.furb.restapifurb.security;

import br.furb.restapifurb.dtos.TokenDTO;
import br.furb.restapifurb.enuns.Roles;
import br.furb.restapifurb.exceptions.runtime.JwtExpiredException;
import br.furb.restapifurb.services.usuario.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Service
public class JwtTokenProvider {

    private final String chaveSecreta = "restapifurb";
    private final long validadeDoToken = 3600000;

    @Autowired
    private UsuarioService userDetailsService;

    public TokenDTO criarTokenDeAcesso(String usuario, Roles role) {
        Date agora = new Date();
        Date expiraEm = new Date(agora.getTime() + validadeDoToken);
        String token = obterTokenDeAcesso(usuario, role, agora, expiraEm);
        return new TokenDTO(usuario, agora, expiraEm, token);
    }

    private String obterTokenDeAcesso(String usuario, Roles role, Date agora, Date expiraEm) {
        String issuerUrl =ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return Jwts.builder()
                .claim("roles", role)
                .setSubject(usuario)
                .setExpiration(expiraEm)
                .signWith(SignatureAlgorithm.HS512, chaveSecreta.getBytes())
                .compact();
    }

    public Authentication obterAutenticacao(String token) {
        Claims claims = decodificarToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private Claims decodificarToken(String token) {
        return Jwts
                .parser()
                .setSigningKey(chaveSecreta.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            return token.substring("Bearer ".length());
        }
        return null;
    }

    public Boolean validarToken(String token) {
        Claims claims = decodificarToken(token);
        try {
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            throw new JwtExpiredException("Token expirado");
        }
    }
}
