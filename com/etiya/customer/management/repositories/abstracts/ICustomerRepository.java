package com.etiya.customer.management.repositories.abstracts;

import com.etiya.customer.management.core.dataAccess.GenericRepository;
import com.etiya.customer.management.entities.concretes.Customer;

import java.util.List;

// JpaRepository<Customer,Integer>
public interface ICustomerRepository extends GenericRepository<Customer> {

}
