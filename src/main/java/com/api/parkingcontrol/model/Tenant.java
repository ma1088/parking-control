package com.api.parkingcontrol.model;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = false, length = 200, unique = true)
    String address;

    @Column(nullable = false, length = 18, unique = true)
    String cnpj;

    @Column(nullable = false)
    LocalDateTime registrationDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    ResponsiblePerson responsiblePerson;
}