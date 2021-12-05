package com.mikehenry.multipledatasources.repository.customer;

import com.mikehenry.multipledatasources.model.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByFirstNameContaining(String firstName);
}
