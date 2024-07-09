package com.programandoenjava.desafiomarzo2024.persistence;

import com.programandoenjava.desafiomarzo2024.entities.Reservas;

import java.util.Date;
import java.util.List;

public interface ReservasDAO {

    // Crear reservas para clientes
        void save(Reservas reservas);
    // Cancelar reservas (Eliminar la reserva)
        void deleteById(Long Id);
    // Modificar fechas de una reserva existente
        Boolean actualizarFechas(Long Id, Date checkIn, Date checkOut);
    // Listar todas las reservas
        List<Reservas> findAll();
    List<Reservas> findByNameClient(String nombreCliente);
}
