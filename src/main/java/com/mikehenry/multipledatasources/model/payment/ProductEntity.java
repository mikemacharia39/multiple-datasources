package com.mikehenry.multipledatasources.model.payment;

import com.mikehenry.multipledatasources.common.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity extends AbstractAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private Long productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "active")
    private int active;
}
