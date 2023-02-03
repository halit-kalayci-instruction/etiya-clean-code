package com.etiya.customer.management.services.rules;


import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.services.abstracts.ICustomerCheckService;

public class CustomerBusinessRules {
    private ICustomerRepository customerRepository;
    private ICustomerCheckService customerCheckService;
    private static CustomerBusinessRules instance;

    public static CustomerBusinessRules getInstance(ICustomerRepository customerRepository,ICustomerCheckService customerCheckService){
        if(instance == null){
            instance = new CustomerBusinessRules();
            instance.customerRepository = customerRepository;
            instance.customerCheckService = customerCheckService;
        }
        return instance;
    }

    public void checkIfCustomerExistsWithSameNationalityId(String nationalityId) throws Exception {
        Customer customer = this.customerRepository.getAll()
                .stream().filter(i->i.getCustomerNo().equals(nationalityId)).findFirst().orElse(null);
        if(customer != null){
            throw new Exception("Bu tckn ile bir müşteri mevcut.");
        }
    }
    public void checkfIfCustomerExistsWithCustomerId(int id) throws Exception
    {
        Customer customer = customerRepository.getById(id);
        if(customer==null)
            throw new Exception("Böyle bir kullanıcı bulunamadı.");
    }
    public void checkIfNationalityIdValid(String name, String lastName, String nationalityId) throws Exception {
        boolean result = customerCheckService.validateNationalityIdentity(name,lastName,nationalityId);
        if(!result)
            throw new Exception("TCKN doğrulanamadı..");
    }

}
