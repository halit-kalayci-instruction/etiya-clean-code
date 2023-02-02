package com.etiya.customer.management.repositories.abstracts;

import com.etiya.customer.management.entities.concretes.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
    void add(Customer customer);
}
