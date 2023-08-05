package br.furb.restapifurb.controllers.produto;

import br.furb.restapifurb.controllers.ControllerImpl;
import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.services.Service;
import br.furb.restapifurb.services.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends ControllerImpl<Produto> {

    @Autowired
    private ProdutoService service;

    @Override
    public Service<Produto> getService() {
        return service;
    }
}
