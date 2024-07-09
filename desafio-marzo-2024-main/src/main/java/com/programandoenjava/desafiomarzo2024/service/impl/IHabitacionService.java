package com.programandoenjava.desafiomarzo2024.service.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.persistence.impl.IHabitacionDAO;
import com.programandoenjava.desafiomarzo2024.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IHabitacionService implements HabitacionService {
    @Autowired
    private IHabitacionDAO iHabitacionDAO;

    @Override
    public void save(Habitacion habitacion) {
        iHabitacionDAO.save(habitacion);
    }

    @Override
    public List<Habitacion> findByDisponible(Boolean disponible) {
        return null;
    }

    @Override
    public Optional<Habitacion> findById(Long id) {

        return iHabitacionDAO.findById(id);
    }

    @Override
    public int updateHabitacion(Long Id) {
        return 0;
    }

    @Override
    public int updateHabitacion(Long id, String tipo, BigDecimal precio) {
        return iHabitacionDAO.updateHabitacion(id, tipo, precio);
    }

    @Override
    public List<Habitacion> habitacionDisponible(Date checkIn, Date checkOut, String tipo) {
        return iHabitacionDAO.habitacionDisponible(checkIn, checkOut, tipo);
    }
}
