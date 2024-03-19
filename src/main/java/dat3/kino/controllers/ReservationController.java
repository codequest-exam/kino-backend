package dat3.kino.controllers;


import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.Reservation;
import dat3.kino.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationResponseDto> getAllReservations(){
        return reservationService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ReservationResponseDto getReservationById(@PathVariable Long id, Principal principal){
        return reservationService.findById(id, principal);
    }

    @GetMapping(path = "/showing/{id}")
    public List<ReservationResponseDto> getReservationsByShowingId(@PathVariable Long id){
        return reservationService.findByShowingId(id);
    }

    @PostMapping
    public ReservationResponseDto addReservation(@RequestBody Reservation reservationToAdd) {
        return reservationService.addReservation(reservationToAdd);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
