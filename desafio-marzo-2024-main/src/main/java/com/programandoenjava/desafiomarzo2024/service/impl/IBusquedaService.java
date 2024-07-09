package com.programandoenjava.desafiomarzo2024.service.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.persistence.impl.IBusquedaDAO;
import com.programandoenjava.desafiomarzo2024.service.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IBusquedaService implements BusquedaService {
    @Autowired
    private IBusquedaDAO iBusquedaDAO;

    @Override
    public List<Habitacion> habitacionDisponible(Date fecha, String tipo) {
        return iBusquedaDAO.habitacionDisponible(fecha, tipo);
    }

    @Override
    public List<Reservas> findByNameClient(String nombreCliente) {
        return iBusquedaDAO.findByNameClient(nombreCliente);
    }
}
