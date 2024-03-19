package dat3.kino.dto;

import dat3.kino.entity.Reservation;
import dat3.security.dto.UserWithRolesResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationResponseDto {
    private Long id;
    private UserWithRolesResponse user;
    private ShowingResponseDto showing;
    private double price;
    private List<SeatResponseDto> reservedSeats;

    public ReservationResponseDto(Reservation reservation) {
        this.id = reservation.getId();
        if (reservation.getUser() != null) {this.user = new UserWithRolesResponse(reservation.getUser());}
        this.showing = new ShowingResponseDto(reservation.getShowing());
        this.price = reservation.getPrice();
        // reserved seats are a list of seat response dto
        //this.reservedSeats = List.of(reservation.getReservedSeats().forEach(seat -> new SeatResponseDto(seat)));
        this.reservedSeats = reservation.getReservedSeats().stream().map(SeatResponseDto::new).toList();
        //this.showing = new ShowingResponseDto(reservation.getShowing());
        //this

    }
}
