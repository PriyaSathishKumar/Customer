package com.Customer.CustomerController;

import com.Customer.CustomerEntity.CustomerEntity;
import com.Customer.CustomerRepository.CustomerRepository;
import com.Customer.CustomerService.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    private static final Logger logger= Logger.getLogger(String.valueOf(CustomerController.class));
    @Autowired
    private CustomerRepository repository;
    //private String query;

    @PostMapping("/addcustomer")
    public CustomerEntity addCustomerDetails(@RequestBody CustomerEntity entity){
        logger.info("added customer Details");
        return service.saveCustomerDetails(entity);
    }
    // get all Customers details
    @GetMapping("/allcustomers")
    public List<CustomerEntity> findAllCustomer() throws JsonProcessingException {

        logger.info("Get All Customer Details "+service.getCustomers());
        return service.getCustomers();
    }
    // get Customer details by ID
    @GetMapping("/customerById/{id}")
    public CustomerEntity findCustomerById(@PathVariable int id) {
        logger.info("Read Customer Details By id " + id);
        CustomerEntity customer=service.getCustomerById(id);
        try{
            if(customer==null){
                throw new Exception("Customer with ID " + id + " not found");
                //return null;
            }else{
                return service.getCustomerById(id);
            }
        }catch (Exception e){
            return null;
        }finally {
            logger.info("Exited");
            return service.getCustomerById(id);
        }

    }
    // get Customer details by name
    @GetMapping("/search")
    public List<CustomerEntity> getCustomerByCustomerName(@RequestParam("query") String query) {
        logger.info("Read Customer Details By Name ");
        return service.getCustomerByCustomerName(query);
    }
    @PutMapping("/updateCustomer")
    public CustomerEntity updateAccount(@RequestBody CustomerEntity entity) {
        logger.info("Account Updated Successfully "+entity);
        return service.updateCustomer(entity);
    }
    @DeleteMapping("/deleteAccount/{id}")
    public String deleteCustomerById(@PathVariable int id) {
        logger.info("Account Deleted Successfuly "+id);
        String s = service.deleteCustomerById(id);
        //return service.deleteAccountById(id);
        return "Account Deleted"+s;
    }



}
