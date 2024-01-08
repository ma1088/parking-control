package com.api.parkingcontrol.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tenant_unit")
public class TenantUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false, length = 10)
    String block;

    @Column(nullable = false, length = 20)
    String unitName;

    @Column(nullable = false)
    LocalDateTime registrationDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    Tenant tenant;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    ResponsiblePerson responsiblePerson;
}
