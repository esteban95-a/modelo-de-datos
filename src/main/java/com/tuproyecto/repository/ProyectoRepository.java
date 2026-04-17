package com.tuproyecto.repository;

import com.tuproyecto.model.entity.Proyecto;
import com.tuproyecto.model.enums.EstadoProyecto;
import com.tuproyecto.model.enums.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para la entidad Proyecto.
 * JpaRepository provee automáticamente: save, findById, findAll,
 * delete, count, y más, sin necesidad de escribir SQL.
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    // Spring Data JPA genera la consulta SQL automáticamente por el nombre del método
    List<Proyecto> findByEstado(EstadoProyecto estado);

    List<Proyecto> findByPrioridad(Prioridad prioridad);
}
