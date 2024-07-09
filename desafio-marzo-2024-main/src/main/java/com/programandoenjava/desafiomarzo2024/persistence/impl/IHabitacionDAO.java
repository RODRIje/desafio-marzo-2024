package com.programandoenjava.desafiomarzo2024.persistence.impl;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.persistence.HabitacionDAO;
import com.programandoenjava.desafiomarzo2024.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class IHabitacionDAO implements HabitacionDAO {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public void save(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    @Override
    public int updateHabitacion(Long id, String tipo, BigDecimal precio) {
         return habitacionRepository.updateHabitacion(id, tipo, precio);
    }

    public Optional<Habitacion> findById(Long id) {
        return  habitacionRepository.findById(id);
    }

    @Override
    public List<Habitacion> habitacionDisponible(Date checkIn, Date checkOut, String tipo) {
        return habitacionRepository.habitacionDisponible(checkIn, checkOut, tipo);
    }
}
