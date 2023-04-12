package br.pucpr.musicserverspring.rest.clients;

import br.pucpr.musicserverspring.lib.exception.BadRequestException;
import br.pucpr.musicserverspring.lib.exception.NotFoundException;
import org.springframework.stereotype.Service;

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

    public Client getById(Long id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
