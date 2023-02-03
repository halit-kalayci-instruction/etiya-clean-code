package com.etiya.customer.management.presentation.console;

import com.etiya.customer.management.core.ccc.authorization.Authorization;
import com.etiya.customer.management.core.ccc.caching.InMemoryCaching;
import com.etiya.customer.management.core.ccc.logging.ConsoleLogger;
import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.entities.concretes.Order;
import com.etiya.customer.management.presentation.console.factories.Factory;
import com.etiya.customer.management.presentation.console.factories.IFactory;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;
import com.etiya.customer.management.repositories.concretes.InMemoryCustomerRepository;
import com.etiya.customer.management.repositories.concretes.InMemoryOrderRepository;
import com.etiya.customer.management.services.abstracts.ICustomerCheckService;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.abstracts.IOrderService;
import com.etiya.customer.management.services.adapters.MernisAdapter;
import com.etiya.customer.management.services.concretes.CustomerCheckService;
import com.etiya.customer.management.services.concretes.CustomerService;
import com.etiya.customer.management.services.concretes.OrderService;
import com.etiya.customer.management.services.facades.OrderServiceFacade;
import com.etiya.customer.management.services.rules.CustomerBusinessRules;
import com.etiya.customer.management.services.rules.OrderBusinessRules;

import java.io.Console;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // IoC Yönetimi
        IFactory factory = new Factory();
        IOrderRepository orderRepository = factory.createOrderRepository();
        ICustomerRepository customerRepository = factory.createCustomerRepository();
        ICustomerCheckService customerCheckService = factory.createCustomerCheckService();
        ICustomerService customerService = factory.createCustomerService();
        //

        Customer customer = new Customer(1,"Halit","Kalaycı","CU500","12345678901","halit@kodlama.io","123");
        customerService.add(customer);

        Customer customer1 = new Customer(2,"Caner","Börekçi","CU510","12345678902","caner@etiya.com","123");
        customerService.add(customer1);

        Customer customerWithId = customerService.getById(2);
        System.out.println(customerWithId.getName());

        IOrderService orderService = factory.createOrderService();

        Order order = new Order(1,"ORD01",customer,new Date(), true);
        orderService.add(order);

        Order order2 = new Order(2,"ORD02",customer1,new Date(), true);
        orderService.add(order2);

        Order order3 = new Order(2,"ORD05",customer1,new Date(), false);
        orderService.update(order3);


        List<Order> orders = orderService.getAll();
        for(Order orderToList: orders){
            System.out.println(orderToList.getOrderNumber());
        }
    }
}
