package com.example.full_code_quynv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="mobile", length = 10)
    private String mobile;

    @Column(name="address", length = 200)
    private String address;

}
