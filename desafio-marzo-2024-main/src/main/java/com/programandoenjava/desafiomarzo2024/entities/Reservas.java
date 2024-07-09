package com.programandoenjava.desafiomarzo2024.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombreCliente;
    private Date checkIn;
    private Date checkOut;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "busqueda_id")
    private Busqueda busqueda;

    public Reservas() {
    }

    public Reservas(Long id, String nombreCliente, Date checkIn, Date checkOut, Habitacion habitacion) {
        Id = id;
        this.nombreCliente = nombreCliente;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
