package com.etiya.customer.management.presentation.console.factories;

import com.etiya.customer.management.core.ccc.authorization.IAuthorization;
import com.etiya.customer.management.core.ccc.caching.ICaching;
import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.abstracts.IOrderRepository;
import com.etiya.customer.management.services.abstracts.ICustomerCheckService;
import com.etiya.customer.management.services.abstracts.ICustomerService;
import com.etiya.customer.management.services.abstracts.IOrderService;
import com.etiya.customer.management.services.rules.CustomerBusinessRules;
import com.etiya.customer.management.services.rules.OrderBusinessRules;

public interface IFactory {
    ILogger createLogger();
    IAuthorization createAuthorization();
    ICaching createCaching();
    IOrderRepository createOrderRepository();
    IOrderService createOrderService();
    //OrderBusinessRules createOrderBusinessRules();
    ICustomerRepository createCustomerRepository();
    ICustomerService createCustomerService();
    //CustomerBusinessRules createCustomerBusinessRules();
    ICustomerCheckService createCustomerCheckService();
}
