package com.tuproyecto.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


    public BaseEntity() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
