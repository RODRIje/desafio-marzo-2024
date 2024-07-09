package com.programandoenjava.desafiomarzo2024.persistence;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;

import java.util.Date;
import java.util.List;

public interface BusquedaDAO {

    // Buscar habitaciones disponibles por fecha y tipo
    List<Habitacion> habitacionDisponible(Date fecha, String tipo);
    // Buscar reservas por nombre del cliente
    List<Reservas> findByNameClient(String nombreCliente);
}
