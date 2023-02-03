package com.etiya.customer.management.services.concretes;

import com.etiya.customer.management.core.ccc.authorization.IAuthorization;
import com.etiya.customer.management.core.ccc.caching.ICaching;
import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.entities.concretes.Order;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.abstracts.IOrderService;
import com.etiya.customer.management.services.facades.OrderServiceFacade;

import java.util.List;

public class OrderService implements IOrderService {
    private OrderServiceFacade orderServiceFacade;
    public OrderService(OrderServiceFacade orderServiceFacade) {
        this.orderServiceFacade = orderServiceFacade;
    }

    @Override
    public List<Order> getAll() {
        // Eğer cachede 'orderService.getAll' keyiyle bir değer varsa bunu döndür, yoksa repostiroyden döndür..
        if(orderServiceFacade.caching.get("orderService.getAll") == null){
            List<Order> orders = orderServiceFacade.orderRepository.getAll();
            orderServiceFacade.caching.cache("orderService.getAll", orders);
            return orders;
        }
        return (List<Order>)orderServiceFacade.caching.get("orderService.getAll");
    }

    @Override
    public Order getById(int id) {
        return orderServiceFacade.orderRepository.getById(id);
    }


    @Override
    public void update(Order order) throws Exception {
        orderServiceFacade.orderBusinessRules.checkIfOrderExistsWithId(order.getId());
        //TODO: Implement validations and etc..
        orderServiceFacade.orderRepository.update(order);
    }

    @Override
    public void delete(Order order) {
        orderServiceFacade.orderRepository.delete(order);
    }

    @Override
    public void add(Order order) throws Exception {
        orderServiceFacade.authorization.authorize();
        orderServiceFacade.logger.log("OrderService.Add");
        orderServiceFacade.customerBusinessRules.checkfIfCustomerExistsWithCustomerId(order.getCustomer().getId());
        checkIfOrderNumberValid(order.getOrderNumber());
        orderServiceFacade.orderRepository.add(order);
    }

    private void checkIfOrderNumberValid(String orderNumber) throws Exception {
        if(orderNumber == null || orderNumber.equals("")){
            throw new Exception("Order number boş olamaz..");
        }
    }
}
