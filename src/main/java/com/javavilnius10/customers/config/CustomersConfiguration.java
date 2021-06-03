package com.javavilnius10.customers.config;

import com.javavilnius10.customers.model.Address;
import com.javavilnius10.customers.model.Customer;
import com.javavilnius10.customers.model.Order;
import com.javavilnius10.customers.repository.CustomerRepository;
import com.javavilnius10.customers.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomersConfiguration {

    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, OrderRepository orderRepository) {
        return args -> {
            Address address = new Address(1L, "Gedimino av. 9, Vilnius");
            Customer customer = new Customer( "UAB Diedas", "022365589", address);
            customerRepository.save(customer);
            Order order = new Order("Automatic generated Text Count", "2021-02-02", "offset printing", 0.32, 3000, customer);
            orderRepository.save(order);
        };
    }
}
