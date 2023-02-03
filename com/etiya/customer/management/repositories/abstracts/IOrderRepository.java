package com.etiya.customer.management.repositories.abstracts;

import com.etiya.customer.management.core.dataAccess.GenericRepository;
import com.etiya.customer.management.entities.concretes.Order;

import java.util.List;

public interface IOrderRepository extends GenericRepository<Order> {
    List<Order> getOrdersByUserId(int id);
}
