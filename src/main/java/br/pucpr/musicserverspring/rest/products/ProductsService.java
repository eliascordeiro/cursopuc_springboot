package br.pucpr.musicserverspring.rest.products;

import br.pucpr.musicserverspring.rest.clients.ClientsService;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    private ProductsRepository repository;
    private ClientsService clientsService;

    public ProductsService(ProductsRepository repository, ClientsService clientsService) {
        this.repository = repository;
        this.clientsService = clientsService;
    }
}
