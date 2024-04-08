package dat3.kino.reservation;

import dat3.kino.seat.Seat;
import dat3.kino.showing.Showing;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ReservationRequestDto {
    private Showing showing;
    private List<Seat> reservedSeats;
    private int phoneNumber;

    public ReservationRequestDto(Showing showing, List<Seat> reservedSeats) {
        this.showing = showing;
        this.reservedSeats = reservedSeats;
    }

    public ReservationRequestDto(){}

    public ReservationRequestDto(Reservation reservation) {
        this.showing = reservation.getShowing();
        this.reservedSeats = reservation.getReservedSeats();
    }
}
