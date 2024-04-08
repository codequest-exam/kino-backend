package dat3.kino.reservation;


import dat3.security.entity.UserWithRoles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get all reservations",
            description = "Returns a list of all reservations",
            responses = {
            @ApiResponse(responseCode = "200", description = "A list of all reservations"),
            @ApiResponse(responseCode = "400", content = @Content, description = "No reservations found")})
    @GetMapping
    public List<ReservationResponseDto> getAllReservations(){
        return reservationService.findAll();
    }

    @Operation(summary = "Get one reservation by id",
            description = "Returns a reservation by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A reservation with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No reservation found with given id")})
    @GetMapping(path = "/{id}")
    public Reservation getReservationByReservationId(@PathVariable Long id, Principal principal) {
    //public ReservationResponseDto getReservationByReservationId(@PathVariable Long id, Principal principal) {
        return reservationService.findById(id, principal);
    }

    @Operation(summary = "Get all reservations by username",
            description = "Returns a list of all reservations by username",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all reservations with given username"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No reservations found with given username")})
    @GetMapping(path = "/user/{user}")
    public List<ReservationResponseDto> getReservationsByUserName(@PathVariable UserWithRoles user, Principal principal){
        return reservationService.findByUsername(user, principal);
    }

    @Operation(summary = "Get all reservations by showing id",
            description = "Returns a list of all reservations by showing id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all reservations with given showing id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No reservations found with given showing id")})
    @GetMapping(path = "/showing/{id}")
    public List<ReservationResponseDto> getReservationsByShowingId(@PathVariable Long id){
        return reservationService.findByShowingId(id);
    }

    @Operation(summary = "Add a reservation",
            description = "Returns a reservation after adding",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reservation added"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Reservation not added")})
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation, Principal principal) {
    //public ReservationResponseDto addReservation(@RequestBody Reservation reservation, Principal principal) {
        return reservationService.addReservation(reservation, principal);
        //return reservationService.addReservation(reservation, principal);
        //return reservationService.addReservation(dto, principal);
    }

    @Operation(summary = "Deletes a reservation",
            description = "Deletes a reservation with given id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reservation deleted"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Reservation not deleted")})
    @DeleteMapping(path = "/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
