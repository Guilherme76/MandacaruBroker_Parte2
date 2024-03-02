package com.mandacarubroker.domain.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "stock")
@Entity(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String symbol;
    private String companyName;
    private double price;

    public Stock(RequestStockDTO requestStockDTO) {
        this.symbol = requestStockDTO.symbol();
        this.companyName = requestStockDTO.companyName();
        this.price = changePrice(requestStockDTO.price(), true);
    }

    /**
     * Método para alterar o preço.
     *
     * @param amount   O valor a ser alterado.
     * @param increase Indica se o preço deve aumentar ou diminuir.
     * @return O novo preço.
     */
    public double changePrice(final double amount, final boolean increase) {
        if (increase) {
            return increasePrice(amount);
        } else {
            return decreasePrice(amount);
        }
    }


    /**
     * Método para aumentar o preço.
     *
     * @param amount O valor a ser adicionado ao preço.
     * @return O novo preço.
     */
    public double increasePrice(final double amount) {
        this.price += amount;
        return this.price;
    }

    /**
     * Método para diminuir o preço.
     *
     * @param amount O valor a ser subtraído do preço.
     * @return O novo preço.
     */
    public double decreasePrice(final double amount) {
        this.price -= amount;
        return this.price;
    }
}
