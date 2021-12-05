package com.mikehenry.multipledatasources.service;

import com.mikehenry.multipledatasources.model.customer.CustomerEntity;
import com.mikehenry.multipledatasources.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstNameContaining(firstName);
    }
}
