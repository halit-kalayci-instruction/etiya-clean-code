package com.etiya.customer.management.repositories.concretes;

import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;

import java.util.List;

public class DatabaseCustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void add(Customer customer) {

    }

}
