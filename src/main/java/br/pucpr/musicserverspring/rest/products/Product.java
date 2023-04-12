package br.pucpr.musicserverspring.rest.products;

import br.pucpr.musicserverspring.rest.clients.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.01", message = "Valor do precoUnitario tem que ser maior que 0.00")
    @Digits(integer=13, fraction=2)
    private BigDecimal precoUnitario;

    @DecimalMin(value = "0.01", message = "Valor da quantidade tem que ser maior que 0.00")
    @Digits(integer=13, fraction=2)
    private BigDecimal quantidade;

    @DecimalMin(value = "0.01", message = "Valor do totalProdutos tem que ser maior que 0.00")
    @Digits(integer=13, fraction=2)
    private BigDecimal totalProdutos;

    @DecimalMin(value = "0.01", message = "Valor do percentualMontagem tem que ser maior que 0.00")
    @Digits(integer=7, fraction=2)
    private BigDecimal percentualMontagem;

    @DecimalMin(value = "0.01", message = "Valor do totalMontagem tem que ser maior que 0.00")
    @Digits(integer=7, fraction=2)
    private BigDecimal totalMontagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    public Product(Long id, String codigo, String descricao, BigDecimal precoUnitario, BigDecimal quantidade, BigDecimal totalProdutos, BigDecimal percentualMontagem, BigDecimal totalMontagem, Client client) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.totalProdutos = totalProdutos;
        this.percentualMontagem = percentualMontagem;
        this.totalMontagem = totalMontagem;
        this.client = client;
    }

    public Long id() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String codigo() {
        return codigo;
    }

    public Product setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String descricao() {
        return descricao;
    }

    public Product setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal precoUnitario() {
        return precoUnitario;
    }

    public Product setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

    public BigDecimal quantidade() {
        return quantidade;
    }

    public Product setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public BigDecimal totalProdutos() {
        return totalProdutos;
    }

    public Product setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
        return this;
    }

    public BigDecimal percentualMontagem() {
        return percentualMontagem;
    }

    public Product setPercentualMontagem(BigDecimal percentualMontagem) {
        this.percentualMontagem = percentualMontagem;
        return this;
    }

    public BigDecimal totalMontagem() {
        return totalMontagem;
    }

    public Product setTotalMontagem(BigDecimal totalMontagem) {
        this.totalMontagem = totalMontagem;
        return this;
    }

    public Client client() {
        return client;
    }

    public Product setClient(Client client) {
        this.client = client;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getCodigo(), product.getCodigo()) && Objects.equals(getDescricao(), product.getDescricao()) && Objects.equals(getPrecoUnitario(), product.getPrecoUnitario()) && Objects.equals(getQuantidade(), product.getQuantidade()) && Objects.equals(getTotalProdutos(), product.getTotalProdutos()) && Objects.equals(getPercentualMontagem(), product.getPercentualMontagem()) && Objects.equals(getTotalMontagem(), product.getTotalMontagem()) && Objects.equals(getClient(), product.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo(), getDescricao(), getPrecoUnitario(), getQuantidade(), getTotalProdutos(), getPercentualMontagem(), getTotalMontagem(), getClient());
    }
}
