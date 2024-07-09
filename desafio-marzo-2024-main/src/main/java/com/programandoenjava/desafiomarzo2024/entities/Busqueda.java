package com.programandoenjava.desafiomarzo2024.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "busqueda")
public class Busqueda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    @OneToMany(mappedBy = "busqueda")
    private List<Reservas> reservas = new ArrayList<>();

    public Busqueda(Long id, Date fecha, String tipo, Habitacion habitacion, List<Reservas> reservas) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.habitacion = habitacion;
        this.reservas = reservas;
    }

    public Busqueda() {
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

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }
}
