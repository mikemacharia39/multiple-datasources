package com.mikehenry.multipledatasources.service;

import com.mikehenry.multipledatasources.model.customer.CustomerEntity;

import java.util.List;

public interface CustomerService {

    List<CustomerEntity> findCustomerByFirstName(String firstName);
}
