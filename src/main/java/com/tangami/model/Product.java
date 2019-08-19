package com.tangami.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Product_Name", length = 64, nullable = false)
    private String productName;

    @Column(name = "Product_Type", length = 64, nullable = false)
    private String productType;

    @Column(name = "Amount", nullable = false)
    private Integer amount;

}
