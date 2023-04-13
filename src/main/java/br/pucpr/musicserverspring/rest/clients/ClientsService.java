package br.pucpr.musicserverspring.rest.clients;

import br.pucpr.musicserverspring.lib.exception.BadRequestException;
import br.pucpr.musicserverspring.lib.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    private final ClientsRepository repository;

    public ClientsService(ClientsRepository repository) {
        this.repository = repository;
    }
    public Client add(Client client){
        if(client == null) throw new BadRequestException("Client cannot be null!");
        if(client.getId() != null) throw new BadRequestException("Cannot save client with an id!");

        return repository.save(client);
    }
    public void delete(Long id){
        if(!repository.existsById(id)) throw new NotFoundException(id);
        repository.deleteById(id);
    }

    public List<Client> search(String id){
        return id == null ? repository.findAll(Sort.by(Sort.Order.asc("nome"))) : repository.findById(id);
    }

    public List<Client> searchName(String nome){
        return nome == null ? repository.findAll(Sort.by(Sort.Order.asc("nome"))) : repository.findByName(nome);
    }

}
