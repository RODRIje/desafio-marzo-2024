package com.programandoenjava.desafiomarzo2024.controllers;


import com.programandoenjava.desafiomarzo2024.controllers.dto.BusquedaDTO;
import com.programandoenjava.desafiomarzo2024.controllers.dto.HabitacionDTO;
import com.programandoenjava.desafiomarzo2024.controllers.dto.ReservaDTO;
import com.programandoenjava.desafiomarzo2024.entities.Busqueda;
import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.service.impl.IBusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/busqueda")
public class BusquedaController {
   /* @Autowired
    private IBusquedaService iBusquedaService;*/

    /*Tarea 8: Buscar Habitaciones Disponibles por Fecha y Tipo
    Buscar habitaciones disponibles por fecha y tipo.
    GIVEN un cliente busca habitaciones disponibles para ciertas fechas y de un tipo específico
    WHEN el cliente envía las fechas y el tipo de habitación deseado
    THEN el sistema devuelve una lista de habitaciones que cumplen con los criterios.*/

    /*@GetMapping("/disponible/{fecha}/{tipo}")
    public ResponseEntity<?> habitacionDisponible(Date fecha, String tipo, @RequestBody HabitacionDTO habitacionDTO, @RequestBody BusquedaDTO busquedaDTO){
        List<Habitacion> habitacionList = iBusquedaService.habitacionDisponible(fecha, tipo);
        if (busquedaDTO.getFecha() != null && busquedaDTO.getTipo() != null){
            Busqueda busqueda = new Busqueda();
            busqueda.setFecha(busquedaDTO.getFecha());
            busqueda.setTipo(busquedaDTO.getTipo());

        }
    }*/
}
