package dat3.kino.controllers;


import dat3.kino.dto.ReservationRequestDto;
import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.Reservation;
import dat3.kino.service.ReservationService;
import dat3.security.entity.UserWithRoles;
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
    public ReservationResponseDto getReservationByReservationId(@PathVariable Long id, Principal principal) {
        return reservationService.findById(id, principal);
    }
    @GetMapping(path = "/user/{user}")
    public List<ReservationResponseDto> getReservationsByUserName(@PathVariable UserWithRoles user, Principal principal){
        return reservationService.findByUsername(user, principal);
    }

    @GetMapping(path = "/showing/{id}")
    public List<ReservationResponseDto> getReservationsByShowingId(@PathVariable Long id){
        return reservationService.findByShowingId(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation, Principal principal) {
    //public ReservationResponseDto addReservation(@RequestBody Reservation reservation, Principal principal) {
        return reservationService.addReservation(reservation, principal);
        //return reservationService.addReservation(reservation, principal);
        //return reservationService.addReservation(dto, principal);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
