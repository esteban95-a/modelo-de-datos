package com.tuproyecto.model.entity;

import com.tuproyecto.model.embeddable.ContactoCliente;
import com.tuproyecto.model.enums.EstadoProyecto;
import com.tuproyecto.model.enums.Prioridad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "proyectos")
@Getter
@Setter
@NoArgsConstructor
public class Proyecto extends BaseEntity {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoProyecto estado;


    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad", nullable = false)
    private Prioridad prioridad;


    @Embedded
    private ContactoCliente contactoCliente;


    public Proyecto(String nombre, String descripcion,
                    EstadoProyecto estado, Prioridad prioridad,
                    ContactoCliente contactoCliente) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.contactoCliente = contactoCliente;
    }
}
