package com.programandoenjava.desafiomarzo2024.service.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.persistence.impl.IReservasDAO;
import com.programandoenjava.desafiomarzo2024.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IReservaService implements ReservaService {
    @Autowired
    private IReservasDAO iReservasDAO;
    @Override
    public void save(Reservas reservas) {
        iReservasDAO.save(reservas);
    }

    @Override
    public void deleteById(Long Id) {
        iReservasDAO.deleteById(Id);
    }

    @Override
    public Boolean actualizarFechas(Long Id, Date checkIn, Date checkOut) {

        return iReservasDAO.actualizarFechas(Id, checkIn, checkOut);
    }

    @Override
    public List<Reservas> findAll() {

        return (List<Reservas>) iReservasDAO.findAll();
    }

    public Optional<Reservas> findById(Long id) {
        return iReservasDAO.findById(id);
    }

    @Override
    public List<Reservas> findByNameClient(String nombreCliente) {
        return iReservasDAO.findByNameClient(nombreCliente);
    }
}
