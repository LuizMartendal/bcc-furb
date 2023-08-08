package br.furb.restapifurb.controllers.comanda;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.models.comanda.ProdutoComanda;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.comanda.ProdutoComandaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviço de ProdutoComanda", description = "Serviço reponsável por gerenciar as relações de produtos e comandas")
@RestController
@RequestMapping("/produto-comanda")
public class ProdutoComandaController extends ControllerImpl<ProdutoComanda> {

    @Autowired
    private ProdutoComandaService service;

    @Override
    public Service<ProdutoComanda> getService() {
        return service;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<ProdutoComanda> create(@RequestBody ProdutoComanda entity) {
        return super.create(entity);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<List<ProdutoComanda>> findAll() {
        return super.findAll();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoComanda> findById(@PathVariable Long id) {
        return super.findById(id);
    }
}
