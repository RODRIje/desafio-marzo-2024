package com.programandoenjava.desafiomarzo2024.persistence.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.persistence.BusquedaDAO;
import com.programandoenjava.desafiomarzo2024.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class IBusquedaDAO implements BusquedaDAO {
    @Autowired
    private BusquedaRepository busquedaRepository;
    @Override
    public List<Habitacion> habitacionDisponible(Date fecha, String tipo) {
        return busquedaRepository.habitacionDisponible(fecha, tipo);
    }
    @Override
    public List<Reservas> findByNameClient(String nombreCliente) {
        return busquedaRepository.findByNameClient(nombreCliente);
    }
}
