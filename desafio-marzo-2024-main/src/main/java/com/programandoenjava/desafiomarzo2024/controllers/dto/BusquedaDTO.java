package com.programandoenjava.desafiomarzo2024.controllers.dto;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class BusquedaDTO {
    private Long id;
    private Date fecha;
    private String tipo;
    private Habitacion habitacion;
    private Reservas reservas;

    public BusquedaDTO(Long id, Date fecha, String tipo, Habitacion habitacion, Reservas reservas) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.habitacion = habitacion;
        this.reservas = reservas;
    }

    public BusquedaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }
}
