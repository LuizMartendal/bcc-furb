package br.furb.restapifurb.controllers;

import br.furb.restapifurb.services.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ControllerImpl<T> implements Controller<T> {

    public abstract Service<T> getService();

    @Operation(
        summary = "Cadastrar novo registro",
        responses = {
            @ApiResponse(responseCode = "200", description = "Quando o registro for criado"),
            @ApiResponse(responseCode = "400", description = "Verifique os dados obrigatórios"),
            @ApiResponse(responseCode = "404", description = "Quando alguma chave estrangeira não for encontrada")
        }
    )
    @PostMapping
    @Override
    public ResponseEntity<T> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Entidade a ser criada")
            @Valid @RequestBody T entity
    ) {
        return ResponseEntity.ok().body(getService().create(entity));
    }

    @Operation(
            summary = "Atualizar um registro existente",
            responses = {
                @ApiResponse(responseCode = "200", description = "Quando o registro for atualizado"),
                @ApiResponse(responseCode = "400", description = "Verifique os dados obrigatórios"),
                @ApiResponse(responseCode = "404", description = "Quando alguma chave estrangeira não for encontrada")
            }
    )
    @PutMapping("/{id}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Override
    public ResponseEntity<T> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Entidade a ser atualizada")
            @Valid @RequestBody T entity,
            @Parameter(required = true, description = "ID do registro a ser atualizado")
            @PathVariable(required = true) Long id
    ) {
        return ResponseEntity.ok().body(getService().update(entity, id));
    }

    @Operation(summary = "Listar todos os registros")
    @GetMapping
    @Override
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok().body(getService().findAll());
    }

    @Operation(summary = "Obter um registro pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Quando o registro for encontrado"),
            @ApiResponse(responseCode = "404", description = "Quando o registro não for encontrado")
    })
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<T> findById(
            @Parameter(description = "ID do registro solicitado", required = true)
            @PathVariable(required = true) Long id
    ) {
        return ResponseEntity.ok().body(getService().findById(id));
    }

    @Operation(summary = "Deletar um registro existente", responses = {
            @ApiResponse(responseCode = "200", description = "Quando o registro for deletado"),
            @ApiResponse(responseCode = "400", description = "Verifique os dados obrigatórios"),
            @ApiResponse(responseCode = "404", description = "Quando o registro não for encontrado") })
    @Override
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @Parameter(description = "ID do registro a ser deletado", required = true)
            @PathVariable(required = true) Long id
    ) {
        getService().delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso!");
    }
}
