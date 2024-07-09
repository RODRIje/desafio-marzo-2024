package com.programandoenjava.desafiomarzo2024.controllers.dto;

import com.programandoenjava.desafiomarzo2024.entities.Busqueda;
import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import lombok.Builder;

import java.util.Date;

@Builder
public class ReservaDTO {
    private Long Id;
    private String nombre;
    private Date checkIn;
    private Date checkOut;

    private Habitacion habitacion;
    private Busqueda busqueda;

    public ReservaDTO(Long id, String nombre, Date checkIn, Date checkOut, Habitacion habitacion, Busqueda busqueda) {
        Id = id;
        this.nombre = nombre;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.habitacion = habitacion;
        this.busqueda = busqueda;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Busqueda getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(Busqueda busqueda) {
        this.busqueda = busqueda;
    }

    public ReservaDTO() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
