package dat3.kino.reservation;

import dat3.kino.seat.SeatResponseDto;
import dat3.kino.showing.ShowingResponseDto;
import dat3.security.dto.UserWithRolesResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationResponseDto {
    private Long id;
    private String email;
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
        this.email = reservation.getEmail();
        //this.showing = new ShowingResponseDto(reservation.getShowing());
        //this

    }
}
