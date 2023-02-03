package com.etiya.customer.management.services.rules;

import com.etiya.customer.management.entities.concretes.Order;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;

import java.util.List;

public class OrderBusinessRules {
    private IOrderRepository orderRepository;
    private static OrderBusinessRules instance;

    public static OrderBusinessRules getInstance(IOrderRepository orderRepository){
        if(instance == null){
            instance = new OrderBusinessRules();
            instance.orderRepository = orderRepository;
        }
        return instance;
    }


    public void checkIfOrderExistsWithId(int id) throws Exception {
        Order order = orderRepository.getById(id);
        if(order==null)
            throw new Exception("Böyle bir order bulunamadı.");
    }

    /**
     * Checks if customer has exceeded the amount of orders
     * @param id the customer id which will be looking in db
     * @throws Exception
     */
    public void checkIfCustomerHasExceededOrderLimit(int id) throws Exception {
        List<Order> orders = orderRepository.getOrdersByUserId(id);
        if(orders.size() > 5)
            throw new Exception("Müşteri daha fazla sipariş veremez..");
    }
}
