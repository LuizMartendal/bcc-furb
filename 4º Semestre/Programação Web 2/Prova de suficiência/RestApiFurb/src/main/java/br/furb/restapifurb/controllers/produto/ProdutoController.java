package br.furb.restapifurb.controllers.produto;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.produto.ProdutoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviço de produtos", description = "Serviço responsável por gerenciar os produtos da lanchonete")
@RestController
@RequestMapping("/produto")
public class ProdutoController extends ControllerImpl<Produto> {

    @Autowired
    private ProdutoService service;

    @Override
    public Service<Produto> getService() {
        return service;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<Produto> create(@RequestBody Produto entity) {
        return super.create(entity);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<List<Produto>> findAll() {
        return super.findAll();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return super.findById(id);
    }
}
