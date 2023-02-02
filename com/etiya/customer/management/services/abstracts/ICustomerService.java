package com.etiya.customer.management.services.abstracts;

import com.etiya.customer.management.entities.concretes.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    void add(Customer customer) throws Exception;
    void update(Customer customer) throws Exception;
}
