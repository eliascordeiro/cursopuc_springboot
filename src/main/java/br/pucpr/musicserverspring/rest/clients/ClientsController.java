package br.pucpr.musicserverspring.rest.clients;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    private ClientsService service;

    public ClientsController(ClientsService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @RolesAllowed("ADMIN")
    @SecurityRequirement(name = "authServer")

    public Client add(@RequestBody @Valid Client client) {
        return service.add(client);
    }

    @DeleteMapping("{id}")
    @Transactional
    @RolesAllowed("ADMIN")
    @SecurityRequirement(name = "authServer")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}

