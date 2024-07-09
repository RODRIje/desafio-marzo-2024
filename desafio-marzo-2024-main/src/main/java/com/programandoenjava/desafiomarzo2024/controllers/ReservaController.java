package com.programandoenjava.desafiomarzo2024.controllers;

import com.programandoenjava.desafiomarzo2024.controllers.dto.ReservaDTO;
import com.programandoenjava.desafiomarzo2024.entities.Reservas;
import com.programandoenjava.desafiomarzo2024.service.impl.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    @Autowired
    private IReservaService iReservaService;

   /* Tarea 4: Crear Reservas para los Clientes
    Permitir a los clientes crear reservas, incluyendo nombre, fechas de check-in y check-out, y habitación.
    GIVEN un cliente desea hacer una reserva en el hotel
    WHEN el cliente envía los detalles de la reserva (nombre del cliente, fechas de check-in y check-out, habitación)
    THEN el sistema registra la reserva y devuelve un mensaje de confirmación.*/

    @PostMapping("/crearreserva")
    public ResponseEntity<?> save(@RequestBody ReservaDTO reservaDTO) throws URISyntaxException {
        Reservas reservas = new Reservas();
        reservas.setNombreCliente(reservaDTO.getNombre());
        reservas.setCheckIn(reservaDTO.getCheckIn());
        reservas.setCheckOut(reservaDTO.getCheckOut());
        reservas.setHabitacion(reservaDTO.getHabitacion());

        iReservaService.save(reservas);

        return ResponseEntity.created(new URI("/api/reserva/crearreserva")).build();
    }

    /*Tarea 5: Cancelar Reservas
    Cancelar reservas existentes.
    GIVEN un cliente desea cancelar una reserva existente
    WHEN el cliente envía la solicitud de cancelación para una reserva específica
    THEN el sistema cancela la reserva y devuelve un mensaje de confirmación.*/

    @DeleteMapping("/eliminarreserva/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable Long id){
        if (id != null){
            iReservaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Id incorrecto");
    }

    /*Tarea 6: Modificar Fechas de una Reserva Existente
    Modificar las fechas de una reserva.
    GIVEN un cliente necesita cambiar las fechas de una reserva existente
    WHEN el cliente envía las nuevas fechas para la reserva
    THEN el sistema actualiza las fechas de la reserva y devuelve un mensaje de confirmación.*/

    @PostMapping("/updatefecha/{id}")
    public ResponseEntity<?> actualizarFechas(@PathVariable Long id, Date checkIn, Date checkOut, @RequestBody ReservaDTO reservaDTO){
        System.out.println("Entrando en el método actualizarFechas");
        if (reservaDTO != null) {
            Optional<Reservas> reservasOptional = iReservaService.findById(id);

            if (reservasOptional.isPresent()){
                Reservas reservas = reservasOptional.get();

                if (reservaDTO.getCheckIn() != null && reservaDTO.getCheckOut() != null){
                    reservas.setCheckIn(reservaDTO.getCheckIn());
                    reservas.setCheckOut(reservaDTO.getCheckOut());
                    iReservaService.save(reservas);
                    System.out.println("Fechas de checkIn y checkOut actualizadas.");
                    return  ResponseEntity.ok("Fechas de checkIn y checkOut actualizadas.");
                }
            }
        }
            System.out.println("Solicitud de actualización de fechas no válida.");
            return  ResponseEntity.badRequest().build();
    }

    /*Tarea 7: Listar Todas las Reservas
    Listar todas las reservas, tanto activas como canceladas.
    GIVEN un usuario desea ver todas las reservas, incluyendo las activas y canceladas
    WHEN el usuario solicita la lista de reservas
    THEN el sistema devuelve una lista de todas las reservas con su estado.*/

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<ReservaDTO> reservasList = iReservaService.findAll()
                .stream()
                .map(reservas -> ReservaDTO.builder()
                                .Id(reservas.getId())
                                .nombre(reservas.getNombreCliente())
                                .checkIn(reservas.getCheckIn())
                                .checkOut(reservas.getCheckOut())
                                .habitacion(reservas.getHabitacion())
                                .build())
                            .toList();

        return  ResponseEntity.ok(reservasList);
    }

    /*Tarea 9: Buscar Reservas por Nombre del Cliente
    Buscar reservas por nombre del cliente.
    GIVEN un usuario desea buscar reservas utilizando el nombre del cliente
    WHEN el usuario envía el nombre del cliente
    THEN el sistema devuelve una lista de reservas asociadas a ese nombre.*/

    @GetMapping("/findbyname/{nombre}")
    public ResponseEntity<?> findByNameClient(@PathVariable String nombre){
        if (nombre != null && !nombre.isEmpty()){
            List<Reservas> reservasList = iReservaService.findByNameClient(nombre);
            return ResponseEntity.ok(reservasList);
        }
        return ResponseEntity.badRequest().build();
    }
}
