package br.furb.restapifurb.controllers.usuario;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.models.usuario.Usuario;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Serviço de usuários", description = "Serviço responsável por gerenciar os usuários da lanchonete")
@RestController
@RequestMapping("usuario")
public class UsuarioController extends ControllerImpl<Usuario> {

    @Autowired
    private UsuarioService service;

    @Override
    public Service<Usuario> getService() {
        return service;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<List<Usuario>> findAll() {
        return super.findAll();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return super.findById(id);
    }

}
