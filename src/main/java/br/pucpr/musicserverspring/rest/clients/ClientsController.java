package br.pucpr.musicserverspring.rest.clients;

import br.pucpr.musicserverspring.rest.clients.DTO.ClientDTO;
import br.pucpr.musicserverspring.rest.products.Product;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
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

        /*
        clientDTO EM CONSTRUCAO
        var addClient = new Client(client.getNome(),
                client.getCep(),
                client.getEndereco(),
                client.getNumero(),
                client.getBairro(),
                client.getCidade(),
                client.getUf(),
                client.getComplemento(),
                client.getPrevisao(),
                client.getDataCadastro(),
                client.getMontador(),
                client.getEmpresa(),
                client.getProduct());
         */
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

