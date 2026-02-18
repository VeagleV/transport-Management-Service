package com.crm.transport.core.entities;

import com.crm.transport.core.enums.Status;
import com.crm.transport.core.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private Integer id;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Integer speed;

    @Column(nullable = false)
    private Double cost;

}
