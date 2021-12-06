package com.mikehenry.multipledatasources.repository.payment;

import com.mikehenry.multipledatasources.model.payment.PaymentEntity;
import com.mikehenry.multipledatasources.model.payment.ProductEntity;
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
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional(value = "paymentTransactionManager")
    void testSavePayment() {
        Random random = new Random();
        int someRand = random.nextInt(9000) + 1000;
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("IPhone X" + someRand);
        productEntity.setDescription("An Apple mobile device");
        productEntity.setActive(1);
        productEntity.setPrice(1000.00);

        ProductEntity savedProd = productRepository.save(productEntity);

        Assertions.assertNotNull(productRepository.findById(1L));

        int quantity = 1;

        PaymentEntity payment = new PaymentEntity();
        payment.setCustomerID(1L);
        payment.setProductID(productEntity.getProductID());
        payment.setActive(1);
        payment.setQuantity(quantity);
        payment.setUnitPrice(productEntity.getPrice());
        payment.setTotalPrice(productEntity.getPrice() * quantity);

        PaymentEntity savedPayment = paymentRepository.save(payment);

        Assertions.assertNotNull(savedPayment.getPaymentID());
    }
}
