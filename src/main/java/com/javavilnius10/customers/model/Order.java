package com.javavilnius10.customers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCount;
    private String date;
    private String textToOrder;
    private Double price;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    public Order(String nameCount, String date, Customer customer, Invoice invoice) {
        this.nameCount = nameCount;
        this.date = date;
        this.customer = customer;
        this.invoice = invoice;
    }

    public Order(String nameCount, String date, String textToOrder, Double price, Integer quantity, Customer customer) {
        this.nameCount = nameCount;
        this.date = date;
        this.textToOrder = textToOrder;
        this.price = price;
        this.quantity = quantity;
        this.customer = customer;
    }



}
