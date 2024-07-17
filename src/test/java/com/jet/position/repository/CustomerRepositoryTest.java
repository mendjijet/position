package com.jet.position.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.jet.position.entity.Customer;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void shouldReturnAllCustomers(){
        //Given


        //When
        List<Customer> customerList = this.customerRepository.findAll();

        //Then
        Assertions.assertEquals(3, customerList.size());
    }
}
