package com.mikehenry.multipledatasources.model.customer;

import com.mikehenry.multipledatasources.common.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity extends AbstractAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerID")
    private Long customerID;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;
}
