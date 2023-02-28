package com.Customer.CustomerRepository;

import com.Customer.CustomerEntity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository1 extends JpaRepository<CustomerEntity,Integer> {
    @Query("SELECT p FROM CustomerEntity p WHERE "+"p.customerFirstName LIKE CONCAT('%',:query,'%')")
    //+ " and p.customerLastName LIKE CONCAT('%',:query,'%')")
    List<CustomerEntity> findBycustomerFirstNameContainingAndIgnoreCase( String query);
}
