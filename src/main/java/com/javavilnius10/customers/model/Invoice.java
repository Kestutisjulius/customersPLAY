package com.javavilnius10.customers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCount;
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Order> orders;

    public Invoice(String nameCount, String date, Customer customer, List<Order> orders) {
        this.nameCount = nameCount;
        this.date = date;
        this.customer = customer;
        this.orders = orders;
    }

    public Invoice(String nameCount, String date, Customer customer) {
        this.nameCount = nameCount;
        this.date = date;
        this.customer = customer;
    }
}
