package com.tuproyecto.config;

import com.tuproyecto.model.embeddable.ContactoCliente;
import com.tuproyecto.model.entity.Proyecto;
import com.tuproyecto.model.enums.EstadoProyecto;
import com.tuproyecto.model.enums.Prioridad;
import com.tuproyecto.repository.ProyectoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner cargarDatos(ProyectoRepository proyectoRepository) {
        return args -> {

            // Solo insertar si la tabla está vacía
            if (proyectoRepository.count() > 0) {
                System.out.println(">>> Ya existen proyectos en la BD. No se insertarán datos de prueba.");
                return;
            }

            System.out.println(">>> Insertando proyectos de prueba...");

            Proyecto p1 = new Proyecto(
                "Sistema de Facturación",
                "Desarrollo de módulo de facturación electrónica",
                EstadoProyecto.EJECUCION,
                Prioridad.ALTA,
                new ContactoCliente("Carlos Gómez", "carlos.gomez@empresa.com", "3001234567")
            );

            Proyecto p2 = new Proyecto(
                "App Móvil de Inventario",
                "Aplicación Android/iOS para gestión de inventario",
                EstadoProyecto.PLANIFICACION,
                Prioridad.MEDIA,
                new ContactoCliente("Laura Martínez", "laura.m@logistica.co", "3109876543")
            );

            Proyecto p3 = new Proyecto(
                "Portal Web Corporativo",
                "Rediseño completo del sitio web institucional",
                EstadoProyecto.FINALIZADO,
                Prioridad.BAJA,
                new ContactoCliente("Andrés Ruiz", "andres.ruiz@corporacion.com", "6014445566")
            );

            proyectoRepository.save(p1);
            proyectoRepository.save(p2);
            proyectoRepository.save(p3);

            System.out.println(">>> ¡3 proyectos insertados exitosamente!");
            System.out.println(">>> Verifica en PostgreSQL: SELECT * FROM proyectos;");
        };
    }
}
