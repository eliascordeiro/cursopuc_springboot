package br.pucpr.musicserverspring.rest.products.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

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
}
