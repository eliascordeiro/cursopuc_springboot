package br.pucpr.musicserverspring.rest.clients.DTO;

import br.pucpr.musicserverspring.rest.products.DTO.ProductDTO;
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

    public ClientDTO(String nome, String cep, String endereco, String numero, String bairro, String cidade, String uf, String complemento, Date previsao, Date dataCadastro, Long montador, Long empresa) {
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.previsao = previsao;
        this.dataCadastro = dataCadastro;
        this.montador = montador;
        this.empresa = empresa;
        }

    public String nome() {
        return nome;
    }

    public ClientDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String cep() {
        return cep;
    }

    public ClientDTO setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String endereco() {
        return endereco;
    }

    public ClientDTO setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String numero() {
        return numero;
    }

    public ClientDTO setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String bairro() {
        return bairro;
    }

    public ClientDTO setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String cidade() {
        return cidade;
    }

    public ClientDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String uf() {
        return uf;
    }

    public ClientDTO setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String complemento() {
        return complemento;
    }

    public ClientDTO setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Date previsao() {
        return previsao;
    }

    public ClientDTO setPrevisao(Date previsao) {
        this.previsao = previsao;
        return this;
    }

    public Date dataCadastro() {
        return dataCadastro;
    }

    public ClientDTO setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public Long montador() {
        return montador;
    }

    public ClientDTO setMontador(Long montador) {
        this.montador = montador;
        return this;
    }

    public Long empresa() {
        return empresa;
    }

    public ClientDTO setEmpresa(Long empresa) {
        this.empresa = empresa;
        return this;
    }

}
