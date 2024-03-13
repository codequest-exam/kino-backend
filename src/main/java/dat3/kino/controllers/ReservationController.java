package dat3.kino.controllers;


import dat3.kino.entity.Reservation;
import dat3.kino.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations/")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.findAll();
    }

    @GetMapping(path = "{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.findById(id);
    }

    @GetMapping(path = "showing/{id}")
    public List<Reservation> getReservationsByShowingId(@PathVariable Long id){
        return reservationService.findByShowingId(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservationToAdd) {
        return reservationService.addReservation(reservationToAdd);
    }

    @DeleteMapping(path = "{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
