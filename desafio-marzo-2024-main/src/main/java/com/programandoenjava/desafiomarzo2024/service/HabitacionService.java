package com.programandoenjava.desafiomarzo2024.service;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HabitacionService {

    // Guardar nuevas Habitaciones
    void save(Habitacion habitacion);

    // Listar Habitaciones disponibles
    List<Habitacion> findByDisponible(Boolean disponible);

    // Buscar habitaciones por Id
    Optional<Habitacion> findById(Long id);

    // Actualizar detalles de las habitaciones
    int updateHabitacion(Long Id);

    int updateHabitacion(Long id, String tipo, BigDecimal precio);

    // Buscar habitaciones disponibles por fecha y tipo
    List<Habitacion> habitacionDisponible(Date checkIn, Date checkOut, String tipo);
}
