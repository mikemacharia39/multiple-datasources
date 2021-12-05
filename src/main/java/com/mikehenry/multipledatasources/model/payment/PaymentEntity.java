package com.mikehenry.multipledatasources.model.payment;

import com.mikehenry.multipledatasources.common.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "payment", schema = "payment")
public class PaymentEntity extends AbstractAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentID")
    private Long paymentID;

    @Column(name = "customerID")
    private Long customerID;

    @Column(name = "productID")
    private Long productID;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "active")
    private int active;
}
