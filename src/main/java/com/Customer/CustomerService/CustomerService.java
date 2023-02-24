package com.Customer.CustomerService;

import com.Customer.CustomerEntity.CustomerEntity;
import com.Customer.CustomerRepository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public CustomerEntity saveCustomerDetails(@RequestBody CustomerEntity entity){
        return repository.save(entity);
    }
    public CustomerEntity getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }
    public List<CustomerEntity> getCustomers() throws JsonProcessingException {
        return repository.findAll();
    }
    // get Customer detail by Customer first name
    @Override
    public List<CustomerEntity> getCustomerByCustomerName(String query) {
        List<CustomerEntity> entity=repository.getCustomerByCustomerName(query);
        return repository.getCustomerByCustomerName(entity);
    }
    public CustomerEntity updateCustomer(CustomerEntity entity) {
        CustomerEntity existingCustomer = repository.findById(entity.getCustomerId()).orElse(null);
        existingCustomer.setCustomerFirstName(entity.getCustomerFirstName());
        existingCustomer.setCustomerLastName(entity.getCustomerLastName());
        existingCustomer.setCustomerGender(entity.getCustomerGender());
        existingCustomer.setCustomerDOB(entity.getCustomerDOB());
        existingCustomer.setCustomerAddress1(entity.getCustomerAddress1());
        existingCustomer.setPinCode(entity.getPinCode());
        existingCustomer.setCustomerPan(entity.getCustomerPan());
        existingCustomer.setCustomerAadhar(entity.getCustomerAadhar());
        existingCustomer.setCustomerMobileNumber(entity.getCustomerMobileNumber());
        existingCustomer.setCustomerMailId(entity.getCustomerMailId());
        return repository.save(existingCustomer);
    }
    public String  deleteCustomerById(int id) {
        repository.deleteById(id);
        return "Account- " + id + " is deleted";
    }
}
