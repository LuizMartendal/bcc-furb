package br.furb.restapifurb.controllers.comanda;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.dtos.ComandaDTO;
import br.furb.restapifurb.models.comanda.Comanda;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.comanda.ComandaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviço de comandas", description = "Serviço responsável por gerenciar as comandas")
@RestController
@RequestMapping("/comanda")
public class ComandaController extends ControllerImpl<ComandaDTO> {

    @Autowired
    private ComandaService service;

    @Override
    public Service<ComandaDTO> getService() {
        return service;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<ComandaDTO> create(@RequestBody ComandaDTO entity) {
        return super.create(entity);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<List<ComandaDTO>> findAll() {
        return super.findAll();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ComandaDTO> findById(@PathVariable Long id) {
        return super.findById(id);
    }
}
