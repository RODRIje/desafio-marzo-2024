package com.programandoenjava.desafiomarzo2024.repository;

import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Habitacion h SET h.tipo = :tipo, h.precio = :precio WHERE h.id = :id")
    int updateHabitacion(@Param("id") Long id, @Param("tipo") String tipo, @Param("precio") BigDecimal precio);


    @Query("SELECT h FROM Habitacion h WHERE h.tipo = :tipo AND h.disponible = true " +
            "AND h.id NOT IN (SELECT r.habitacion.id FROM Reservas r " +
            "WHERE (:checkIn BETWEEN r.checkIn AND r.checkOut) OR (:checkOut BETWEEN r.checkIn AND r.checkOut))")
    List<Habitacion> habitacionDisponible(@Param("checkIn") Date checkIn,
                                          @Param("checkOut") Date checkOut,
                                          @Param("tipo") String tipo);
}
