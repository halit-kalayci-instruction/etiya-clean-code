package com.etiya.customer.management.presentation.console;

import com.etiya.customer.management.core.ccc.logging.ConsoleLogger;
import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.concretes.InMemoryCustomerRepository;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.adapters.MernisAdapter;
import com.etiya.customer.management.services.concretes.CustomerCheckService;
import com.etiya.customer.management.services.concretes.CustomerService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // IoC Yönetimi
        ICustomerService customerService = new CustomerService(
                new InMemoryCustomerRepository(),
                new ConsoleLogger(),
                new CustomerCheckService());
        Customer customer = new Customer(1,"Halit","Kalaycı","CU500","12345678901","halit@kodlama.io","123");
        customerService.add(customer);

        Customer customer1 = new Customer(2,"Caner","Börekçi","CU510","12345678902","caner@etiya.com","123");
        customerService.add(customer1);
        /*Customer customer1 = new Customer(2,"Caner","Börekçi","CU510","1","caner@etiya.com","123");
        customerService.add(customer1);*/

        List<Customer> customers = customerService.getAll();
        for(Customer dbCustomer:customers){
            System.out.println(dbCustomer.getName());
        }
    }
}
