package com.Customer.CustomerEntity;

import co.elastic.clients.elasticsearch.core.MtermvectorsRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.TermVector;
import org.springframework.stereotype.Indexed;
import org.springframework.data.elasticsearch.annotations.Field;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Indexed
@Table(name = "custTable")
// table name in DB
//Table Name=customer_table
public class CustomerEntity {

         // Declare variable - customerId
        // primary key
        @Id
        @GeneratedValue
        // column name in table
        //@Column(name = "Customer_Id")
        private int customerId;
        // Declare variable - customerFirstName
        //@Column(name = "Customer_FirstName")
       //@Field(termvector TermVector.yes)
        private String customerFirstName;
        // Declare variable - customerLastName
        // column name in table
        //@Column(name = "Customer_LastName")
        //@Field(termvector TermVector.yes)
        private String customerLastName;

        // Declare variable - customerGender
        // column name in table
        //@Column(name = "Customer_Gender")
        private String customerGender;

        // Declare variable - customerDOB
        // column name in table
        //@Column(name = "Customer_DOB")
        private Date customerDOB;

        // Declare variable - customerAddress1
        // column name in table
        //@Column(name = "Customer_Address1")
        private String customerAddress1;

        // Declare variable - customerAddress2
        // column name in table
        // @Column(name = "Customer_Address2")
        private int pinCode;

        // Declare variable - customerPan
        // column name in table
        //@Column(name = "Customer_Pan")
        private String customerPan;

        // Declare variable - customerAadhar
        // column name in table
        //@Column(name = "Customer_Aadhar")
        private int customerAadhar;

        // Declare variable - customerMobileNumber
        // column name in table
        //@Column(name = "Customer_MobileNumber")
        private long customerMobileNumber;

        // Declare variable - customerMailId
        // column name in table
        //@Column(name = "Customer_MailId")
        private String customerMailId;
    }


