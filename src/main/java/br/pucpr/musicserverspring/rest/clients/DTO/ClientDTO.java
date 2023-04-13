package br.pucpr.musicserverspring.rest.clients.DTO;

import br.pucpr.musicserverspring.rest.products.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class ClientDTO {

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

    private List<Product> product = new ArrayList<>();
}
