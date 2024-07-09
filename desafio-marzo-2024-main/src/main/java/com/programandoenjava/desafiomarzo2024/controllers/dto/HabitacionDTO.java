package com.programandoenjava.desafiomarzo2024.controllers.dto;

import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class HabitacionDTO {
    private Long id;
    private BigDecimal precio;
    private String tipo;
    private Boolean disponible;

    private Reservas reservas;

    public HabitacionDTO(Long id, BigDecimal precio, String tipo, Boolean disponible, Reservas reservas) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
        this.reservas = reservas;
    }

    public HabitacionDTO() {
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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }
}
