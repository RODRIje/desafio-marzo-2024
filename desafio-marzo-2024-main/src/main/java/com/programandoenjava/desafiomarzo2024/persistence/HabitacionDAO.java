package com.programandoenjava.desafiomarzo2024.persistence;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HabitacionDAO {

    // Guardar nuevas Habitaciones
    void save(Habitacion habitacion);

    // Actualizar detalles de las habitaciones
    int updateHabitacion(Long id, String tipo, BigDecimal precio);

     Optional<Habitacion> findById(Long id);

    // Buscar habitaciones disponibles por fecha y tipo
    List<Habitacion> habitacionDisponible(Date checkIn, Date checkOut, String tipo);
}
