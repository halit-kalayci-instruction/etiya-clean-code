package com.etiya.customer.management.services.facades;

import com.etiya.customer.management.core.ccc.authorization.IAuthorization;
import com.etiya.customer.management.core.ccc.caching.ICaching;
import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.rules.CustomerBusinessRules;
import com.etiya.customer.management.services.rules.OrderBusinessRules;

public class OrderServiceFacade {
    public IOrderRepository orderRepository;
    public ICustomerService customerService;
    public ILogger logger;
    public IAuthorization authorization;
    public ICaching caching;
    public OrderBusinessRules orderBusinessRules;
    public CustomerBusinessRules customerBusinessRules;

    public OrderServiceFacade(IOrderRepository orderRepository,
                              ICustomerService customerService,
                              ILogger logger,
                              IAuthorization authorization,
                              ICaching caching,
                              CustomerBusinessRules customerBusinessRules) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.logger = logger;
        this.authorization = authorization;
        this.caching = caching;
        orderBusinessRules = OrderBusinessRules.getInstance(orderRepository);
        this.customerBusinessRules = customerBusinessRules;
    }
}
