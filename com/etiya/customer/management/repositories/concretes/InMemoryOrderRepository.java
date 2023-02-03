package com.etiya.customer.management.repositories.concretes;

import com.etiya.customer.management.entities.concretes.Order;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements IOrderRepository {
    List<Order> orders;

    public InMemoryOrderRepository() {
        this.orders = new ArrayList<>();
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order getById(int id) {
        return orders.stream().filter(i->i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void add(Order entity) {
        orders.add(entity);
    }

    @Override
    public void update(Order entity) {
        Order entityToUpdate = getById(entity.getId());
        int index = orders.indexOf(entityToUpdate);
        orders.set(index,entity);
        /*
        entityToUpdate.setActive(entity.isActive());
        entityToUpdate.setCustomer(entity.getCustomer());
        entityToUpdate.setOrderDate(entity.getOrderDate());
        entityToUpdate.setOrderNumber(entity.getOrderNumber());
        */
    }

    @Override
    public void delete(Order entity) {
        orders.remove(entity);
    }

    @Override
    public List<Order> getOrdersByUserId(int id) {
        return orders.stream().filter(i->i.getCustomer().getId() == id).toList();
    }
}
