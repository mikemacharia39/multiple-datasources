package com.mikehenry.multipledatasources;

import com.mikehenry.multipledatasources.model.customer.CustomerEntity;
import com.mikehenry.multipledatasources.model.payment.PaymentEntity;
import com.mikehenry.multipledatasources.service.CustomerService;
import com.mikehenry.multipledatasources.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class MultipleDatasourcesApplication implements CommandLineRunner {

	private final PaymentService paymentService;
	private final CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatasourcesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerEntity> findCustomerByFName = customerService.findCustomerByFirstName("Mike");

		log.info("Customers =================================");
		findCustomerByFName.forEach(System.out::println);

		List<PaymentEntity> allPayments = paymentService.fetchAllPayments();
		log.info("Payments =================================");
		allPayments.forEach(System.out::println);

	}
}
