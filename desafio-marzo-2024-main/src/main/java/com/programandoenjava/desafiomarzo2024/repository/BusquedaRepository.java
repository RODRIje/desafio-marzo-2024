package com.programandoenjava.desafiomarzo2024.repository;

import com.programandoenjava.desafiomarzo2024.entities.Busqueda;
import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BusquedaRepository extends CrudRepository<Busqueda, Long> {
    // Buscar habitaciones disponibles por fecha y tipo
    @Query("SELECT COUNT(b) = 0 FROM Busqueda b WHERE b.fecha = :fecha AND b.tipo = :tipo")
    List<Habitacion> habitacionDisponible(@Param("fecha") Date fecha, @Param("tipo") String tipo);
    // Buscar reservas por nombre del cliente
    @Query("SELECT r FROM Reservas r WHERE r.nombreCliente = :nombreCliente")
    List<Reservas> findByNameClient(@Param("nombreCliente") String nombreCliente);
}
