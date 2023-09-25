package com.order.equitymarket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDER")
    @SequenceGenerator(name = "SEQ_ORDER", sequenceName = "SEQ_ORDER")
    private int id;

    @Column(name = "STOCK_NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "PRICE")
    private double price;

    public Order(String name, String category, String product, double price) {
        this.name = name;
        this.category = category;
        this.product = product;
        this.price = price;
    }
}
