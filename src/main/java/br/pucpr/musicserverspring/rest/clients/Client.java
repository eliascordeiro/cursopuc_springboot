package br.pucpr.musicserverspring.rest.clients;

import br.pucpr.musicserverspring.rest.products.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//@NamedQuery(name="Client.findByGenre", query = "SELECT a from Client a join a.genres g where g = :genre ORDER BY a.name")
public class Client {

    @Id
    @GeneratedValue
    @Schema(hidden = true)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotBlank
    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    @NotBlank
    private String complemento;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date previsao;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataCadastro;

    private Long montador;

    private Long empresa;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Product> product = new ArrayList<>();
}
