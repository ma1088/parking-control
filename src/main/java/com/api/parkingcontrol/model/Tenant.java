package com.api.parkingcontrol.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tenant")
public class Tenant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "name", nullable = false, length = 100)
    String name;

    @Column(name = "address", nullable = false, length = 200, unique = true)
    String address;

    @Column(name = "cnpj", nullable = false, length = 14)
    Long cnpj;
}