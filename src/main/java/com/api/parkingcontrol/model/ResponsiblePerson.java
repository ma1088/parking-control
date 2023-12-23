package com.api.parkingcontrol.model;

import java.util.UUID;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_responsible_person")
public class ResponsiblePerson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, length = 125)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime registrationDate;
}
