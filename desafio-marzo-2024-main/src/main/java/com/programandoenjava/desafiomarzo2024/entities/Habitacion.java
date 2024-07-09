package com.programandoenjava.desafiomarzo2024.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "habitacion")
public class Habitacion {

    // Id es el numero que identifica la habitacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Precio de la habitacion.
    @Column(name = "precio")
    private BigDecimal precio;
    // Tipo de habitacion(Simple, doble y premium)
    @Column(name = "tipo")
    private String tipo;
    // Estado de la habitacion (Disponible - No disponible)
    @Column(name = "disponible")
    private Boolean disponible;

    @OneToMany(mappedBy = "habitacion")
    @JsonIgnore
    private List<Reservas> reservas = new ArrayList<>();

    public Habitacion(Long id, BigDecimal precio, String tipo, Boolean disponible, List<Reservas> reservas) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
        this.reservas = reservas;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }

    public Habitacion() {
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
