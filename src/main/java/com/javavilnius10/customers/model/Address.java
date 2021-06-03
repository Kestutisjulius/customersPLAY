package com.javavilnius10.customers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressLine;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address(String addressLine) {
        this.addressLine = addressLine;
    }

    public Address(String addressLine, Customer customer) {
        this.addressLine = addressLine;
        this.customer = customer;
    }

    public Address(Long id, String addressLine) {
        this.id = id;
        this.addressLine = addressLine;
    }
}
