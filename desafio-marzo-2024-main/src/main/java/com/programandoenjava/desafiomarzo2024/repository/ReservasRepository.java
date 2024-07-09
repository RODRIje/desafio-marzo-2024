package com.programandoenjava.desafiomarzo2024.repository;

import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservasRepository extends CrudRepository<Reservas, Long> {

    @Query("UPDATE Reservas r SET r.checkIn = :checkIn, r.checkOut = :checkOut WHERE r.id = :id")
    int actualizarFechas(@Param("id") Long id, @Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);

    @Query("SELECT r FROM Reservas r WHERE r.nombreCliente = :nombreCliente")
    List<Reservas> findByNameClient(@Param("nombreCliente") String nombreCliente);
}
