package com.etiya.customer.management.presentation.console.factories;

import com.etiya.customer.management.core.ccc.authorization.Authorization;
import com.etiya.customer.management.core.ccc.authorization.IAuthorization;
import com.etiya.customer.management.core.ccc.caching.ICaching;
import com.etiya.customer.management.core.ccc.caching.InMemoryCaching;
import com.etiya.customer.management.core.ccc.caching.RedisCaching;
import com.etiya.customer.management.core.ccc.logging.ConsoleLogger;
import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.core.ccc.logging.SMSLogger;
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

public class Factory implements IFactory{
    @Override
    public ILogger createLogger() {
        return new SMSLogger();
    }

    @Override
    public IAuthorization createAuthorization() {
        return new Authorization();
    }

    @Override
    public ICaching createCaching() {
        return new RedisCaching();
    }

    @Override
    public IOrderRepository createOrderRepository() {
        return new InMemoryOrderRepository();
    }

    @Override
    public ICustomerRepository createCustomerRepository() {
        return new InMemoryCustomerRepository();
    }

    @Override
    public ICustomerCheckService createCustomerCheckService() {
        return new MernisAdapter();
    }


    @Override
    public IOrderService createOrderService() {
        IOrderRepository orderRepository = createOrderRepository();
        OrderServiceFacade orderServiceFacade = new OrderServiceFacade(
                orderRepository,
                createCustomerService(),
                createLogger(),
                createAuthorization(),
                createCaching(),
                CustomerBusinessRules.getInstance(createCustomerRepository(),createCustomerCheckService())
        );
        return new OrderService(orderServiceFacade);
    }
    @Override
    public ICustomerService createCustomerService() {
        return new CustomerService(createCustomerRepository(),createLogger(),createCustomerCheckService());
    }


}
