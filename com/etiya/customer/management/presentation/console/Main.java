package com.etiya.customer.management.presentation.console;

import com.etiya.customer.management.core.ccc.logging.ConsoleLogger;
import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.concretes.InMemoryCustomerRepository;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.concretes.CustomerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // IoC Yönetimi
        ICustomerService customerService = new CustomerService(
                new InMemoryCustomerRepository(),
                new ConsoleLogger());
        List<Customer> customers = customerService.getAll();
        System.out.println(customers.size());
    }
}
