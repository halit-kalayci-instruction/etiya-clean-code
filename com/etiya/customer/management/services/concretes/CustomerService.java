package com.etiya.customer.management.services.concretes;

import com.etiya.customer.management.core.ccc.logging.ILogger;
import com.etiya.customer.management.entities.concretes.Customer;
import com.etiya.customer.management.repositories.abstracts.ICustomerRepository;
import com.etiya.customer.management.repositories.concretes.InMemoryCustomerRepository;
import com.etiya.customer.management.services.abstracts.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;
    private ILogger logger;
    public CustomerService(ICustomerRepository customerRepository,ILogger logger) {
            this.customerRepository = customerRepository;
            this.logger = logger;
    }

    @Override
    public List<Customer> getAll() {
        // kullanıcı giriş yapmış mı?
        isUserAuthenticated();
        // veri erişimden veriyi iste..
        // if suistimali
        logger.log("CustomerService.GetAll()");
        return customerRepository.getAll();
    }

    @Override
    public void add(Customer customer) throws Exception {
        // validasyon
        // iş kuralı
        // loglama
        // cacheBroke
        validateCustomer(customer);
        checkIfCustomerExistsWithSameNationalityId(customer.getNationalityId());
        customerRepository.add(customer);
    }

    @Override
    public void update(Customer customer) throws Exception {
        checkIfCustomerExistsWithSameNationalityId(customer.getNationalityId());
    }

    private void validateCustomer(Customer customer) throws Exception {
        validateCustomerNationalityId(customer.getNationalityId());
        // validasyon => java.validation
        // @NotNull
    }
    private void validateCustomerNationalityId(String nationalityId) throws Exception {
        if(nationalityId.length() != 11)
            throw new Exception("TC Kimlik 11 hane olmalıdır.");
    }
    private void checkIfCustomerExistsWithSameNationalityId(String nationalityId) throws Exception {
        if(this.customerRepository.getAll()
                .stream().filter(i->i.getCustomerNo().equals(nationalityId)) != null){
            throw new Exception("Bu tckn ile bir müşteri mevcut.");
        }
    }
    private void isUserAuthenticated(){
        System.out.println("Kullanıcı giriş yapmış durumda..");
    }
}
