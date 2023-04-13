package br.pucpr.musicserverspring.rest.clients;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /*
    @Transactional
    @GetMapping("search")
    public Set<Album> searchAlbums(
            @RequestParam(required = false) Long artistId,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer to,
            @RequestParam(required = false) String genre){
        return service.search(artistId, from, to, genre);
    }
    */

    @GetMapping("search")
    @Transactional
    public List<Client> search(@RequestParam(value = "id", required = false) String id){
        return service.search(id);
    }

    @GetMapping("searchName")
    @Transactional
    public List<Client> searchName(@RequestParam(value = "nome", required = false) String nome){
        return service.searchName(nome);
    }

}

