package br.furb.restapifurb.controllers.usuario;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.models.usuario.Usuario;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends ControllerImpl<Usuario> {

    @Autowired
    private UsuarioService service;

    @Override
    public Service<Usuario> getService() {
        return service;
    }
}
