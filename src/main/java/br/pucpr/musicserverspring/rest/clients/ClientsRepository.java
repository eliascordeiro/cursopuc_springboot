package br.pucpr.musicserverspring.rest.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
    List<Client> findById(String id);
    List<Client> findByName(String nome);
}
