package com.mikehenry.multipledatasources.repository.customer;

import com.mikehenry.multipledatasources.model.customer.CustomerEntity;
import com.mikehenry.multipledatasources.model.customer.CustomerStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional("customerTransactionManager")
    void testCreateCustomer() {
        Random random = new Random();
        int suffix = random.nextInt(90000)+10000;
        CustomerEntity customer = new CustomerEntity();
        customer.setEmailAddress("mike" + suffix +"@gmail.com");
        customer.setFirstName("Mike " + suffix);
        customer.setLastName("Maina " + suffix);
        customer.setStatus(CustomerStatus.ACTIVE);

        CustomerEntity savedCustomer = customerRepository.save(customer);

        Assertions.assertNotNull(customerRepository.findByFirstNameContaining("Mike"));
    }
}
