package com.rsn.pagination.pagination_with_sorting.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Prod_table")
@Data
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int quantity;

    private long price;

    public Product(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
