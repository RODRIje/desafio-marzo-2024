package com.programandoenjava.desafiomarzo2024.controllers;

import com.programandoenjava.desafiomarzo2024.controllers.dto.HabitacionDTO;
import com.programandoenjava.desafiomarzo2024.controllers.dto.ReservaDTO;
import com.programandoenjava.desafiomarzo2024.entities.Habitacion;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.service.impl.IHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {
    @Autowired
    private IHabitacionService iHabitacionService;

    // Tarea 1: Registrar nuevas habitaciones
    //Registrar nuevas habitaciones con detalles como identificador, tipo y precio.
    //
    //GIVEN un administrador desea agregar una nueva habitación al sistema
    //WHEN el administrador envía los detalles de la habitación (identificador, tipo, precio)
    //THEN el sistema registra la nueva habitación y devuelve un mensaje de éxito.
    @PostMapping("/registrarhabitacion")
    public ResponseEntity<?> save(@RequestBody HabitacionDTO habitacionDTO) throws URISyntaxException {
        Habitacion habitacion = new Habitacion();
        habitacion.setId(habitacionDTO.getId());
        habitacion.setTipo(habitacionDTO.getTipo());
        habitacion.setPrecio(habitacionDTO.getPrecio());
        habitacion.setDisponible(habitacionDTO.getDisponible());

        iHabitacionService.save(habitacion);

        return ResponseEntity.created(new URI("/api/habitacion/registrarhabitacion")).build();
    }

   /* Tarea 2: Listar Todas las Habitaciones Disponibles
    Listar todas las habitaciones disponibles.

    GIVEN un usuario desea ver todas las habitaciones disponibles
    WHEN el usuario solicita la lista de habitaciones disponibles
    THEN el sistema devuelve una lista de todas las habitaciones disponibles.*/

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findByDisponible(@PathVariable Long id){
        Optional<Habitacion> habitacionOptional = iHabitacionService.findById(id);
        if (habitacionOptional.isPresent()){
            Habitacion habitacion = habitacionOptional.get();
            HabitacionDTO habitacionDTO = HabitacionDTO.builder()
                    .id(habitacion.getId())
                    .tipo(habitacion.getTipo())
                    .precio(habitacion.getPrecio())
                    .disponible(habitacion.getDisponible())
                    .build();

            return ResponseEntity.ok(habitacionDTO);
        }
            return ResponseEntity.notFound().build();
    }

   /*Tarea 3: Actualizar Detalles de las Habitaciones
    Actualizar los detalles de las habitaciones.

    GIVEN un administrador desea actualizar los detalles de una habitación existente
    WHEN el administrador envía los nuevos detalles de la habitación (tipo, precio)
    THEN el sistema actualiza los detalles de la habitación y devuelve un mensaje de confirmación.*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHabitacion(@PathVariable Long id, @RequestBody HabitacionDTO habitacionDTO) {
        // Verifica si el ID es válido
        if (id != null && id > 0 && habitacionDTO != null) {
            // Obtener la habitación existente por ID
            Optional<Habitacion> habitacionOptional = iHabitacionService.findById(id);

            if (habitacionOptional.isPresent()) {
                // Obtener la habitación del Optional
                Habitacion habitacion = habitacionOptional.get();

                // Actualizar los valores de tipo y precio si son diferentes de null en el DTO
                if (habitacionDTO.getTipo() != null) {
                    habitacion.setTipo(habitacionDTO.getTipo());
                }
                if (habitacionDTO.getPrecio() != null) {
                    habitacion.setPrecio(habitacionDTO.getPrecio());
                }
                // Guardar la habitación actualizada solo si al menos uno de los campos no es null
                if (habitacionDTO.getTipo() != null || habitacionDTO.getPrecio() != null) {
                    iHabitacionService.save(habitacion);
                    return ResponseEntity.ok("Campos actualizados");
                } else {
                    return ResponseEntity.ok("No se actualizaron campos ya que ambos son nulos");
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /*Tarea 8: Buscar Habitaciones Disponibles por Fecha y Tipo
    Buscar habitaciones disponibles por fecha y tipo.
    GIVEN un cliente busca habitaciones disponibles para ciertas fechas y de un tipo específico
    WHEN el cliente envía las fechas y el tipo de habitación deseado
    THEN el sistema devuelve una lista de habitaciones que cumplen con los criterios.*/

    @GetMapping("/disponible/{checkIn}/{checkOut}/{tipo}")
    public ResponseEntity<?> habitacionDisponible(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkIn,
                                                  @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkOut,
                                                  @PathVariable String tipo){
        List<Habitacion> habitacionList = iHabitacionService.habitacionDisponible(checkIn, checkOut, tipo);
        return ResponseEntity.ok(habitacionList);

        /* HAY QUE CORREGIR EL METODO, YA QUE SOLO DEVUELVE LA LISTA DE HABITACIONES DISPONIBLES
        SOLO SI EN LA URI PONEMOS MAL LA EL AÑO EN LA FECHA DEL CHECKIN Y CHECKOUT.
         */
    }

}
