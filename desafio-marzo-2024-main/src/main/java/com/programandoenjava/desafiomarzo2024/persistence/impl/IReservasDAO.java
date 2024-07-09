package com.programandoenjava.desafiomarzo2024.persistence.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.persistence.ReservasDAO;
import com.programandoenjava.desafiomarzo2024.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class IReservasDAO implements ReservasDAO {
    @Autowired
    private ReservasRepository reservasRepository;

    @Override
    public void save(Reservas reservas) {
        reservasRepository.save(reservas);
    }

    @Override
    public void deleteById(Long Id) {
        reservasRepository.deleteById(Id);
    }

    @Override
    public Boolean actualizarFechas(Long id, Date checkIn, Date checkOut) {
        int filasActualizadas = reservasRepository.actualizarFechas(id, checkIn, checkOut);
        return filasActualizadas > 0; // Devuelve true si se han actualizado filas, false de lo contrario
    }

    @Override
    public List<Reservas> findAll() {
        return (List<Reservas>) reservasRepository.findAll();
    }

    public Optional<Reservas> findById(Long id) {
        return reservasRepository.findById(id);
    }

    @Override
    public List<Reservas> findByNameClient(String nombreCliente) {
        return reservasRepository.findByNameClient(nombreCliente);
    }
}
