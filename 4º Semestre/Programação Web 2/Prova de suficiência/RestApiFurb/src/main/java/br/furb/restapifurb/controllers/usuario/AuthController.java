package br.furb.restapifurb.controllers.usuario;

import br.furb.restapifurb.dtos.CredenciaisDTO;
import br.furb.restapifurb.dtos.TokenDTO;
import br.furb.restapifurb.services.usuario.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autenticação", description = "Serviço responsável pela autenticação do usuário")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody CredenciaisDTO credenciaisDTO) {
        return ResponseEntity.ok(authService.signin(credenciaisDTO));
    }
}
