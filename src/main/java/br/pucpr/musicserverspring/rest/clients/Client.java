package br.pucpr.musicserverspring.rest.clients;

import br.pucpr.musicserverspring.rest.products.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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

    public Client(String nome, String cep, String endereco, String numero, String bairro, String cidade, String uf, String complemento, Date previsao, Date dataCadastro, Long montador, Long empresa, List<Product> product) {
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
        this.product = product;
    }

    public Long id() {
        return id;
    }

    public Client setId(Long id) {
        this.id = id;
        return this;
    }

    public String nome() {
        return nome;
    }

    public Client setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String cep() {
        return cep;
    }

    public Client setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String endereco() {
        return endereco;
    }

    public Client setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String numero() {
        return numero;
    }

    public Client setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String bairro() {
        return bairro;
    }

    public Client setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String cidade() {
        return cidade;
    }

    public Client setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String uf() {
        return uf;
    }

    public Client setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String complemento() {
        return complemento;
    }

    public Client setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Date previsao() {
        return previsao;
    }

    public Client setPrevisao(Date previsao) {
        this.previsao = previsao;
        return this;
    }

    public Date dataCadastro() {
        return dataCadastro;
    }

    public Client setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public Long montador() {
        return montador;
    }

    public Client setMontador(Long montador) {
        this.montador = montador;
        return this;
    }

    public Long empresa() {
        return empresa;
    }

    public Client setEmpresa(Long empresa) {
        this.empresa = empresa;
        return this;
    }

    public List<Product> product() {
        return product;
    }

    public Client setProduct(List<Product> product) {
        this.product = product;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getNome(), client.getNome()) && Objects.equals(getCep(), client.getCep()) && Objects.equals(getEndereco(), client.getEndereco()) && Objects.equals(getNumero(), client.getNumero()) && Objects.equals(getBairro(), client.getBairro()) && Objects.equals(getCidade(), client.getCidade()) && Objects.equals(getUf(), client.getUf()) && Objects.equals(getComplemento(), client.getComplemento()) && Objects.equals(getPrevisao(), client.getPrevisao()) && Objects.equals(getDataCadastro(), client.getDataCadastro()) && Objects.equals(getMontador(), client.getMontador()) && Objects.equals(getEmpresa(), client.getEmpresa()) && Objects.equals(getProduct(), client.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCep(), getEndereco(), getNumero(), getBairro(), getCidade(), getUf(), getComplemento(), getPrevisao(), getDataCadastro(), getMontador(), getEmpresa(), getProduct());
    }
}
