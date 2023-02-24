package com.Customer.CustomerRepository;

import com.Customer.CustomerEntity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
    @Query("SELECT * FROM CustomerEntity p WHERE "+"p.customerFirstName LIKE CONCAT('%',:query,'%')"+
            "p.customerLastName LIKE CONCAT('%',:query,'%')")
    List<CustomerEntity> getCustomerByCustomerName(String query);
}
