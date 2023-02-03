package com.etiya.customer.management.services.rules;

import com.etiya.customer.management.entities.concretes.Order;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;

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
}
