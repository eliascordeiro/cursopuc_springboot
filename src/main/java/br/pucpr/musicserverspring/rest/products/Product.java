package br.pucpr.musicserverspring.rest.products;

import br.pucpr.musicserverspring.rest.clients.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(hidden = true)
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
    @Schema(hidden = true)
    private Client client;
}
