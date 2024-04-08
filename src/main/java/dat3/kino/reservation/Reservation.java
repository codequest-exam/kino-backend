package dat3.kino.reservation;

import dat3.kino.seat.Seat;
import dat3.kino.showing.Showing;
import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Showing showing;

    @NotNull
    private double price;

    @ManyToOne
    private UserWithRoles user;

    private String email;

    @NotNull
    @ManyToMany
    private List<Seat> reservedSeats;
//    @NotNull
//    @OneToMany
//    private List<Seat> reservedSeats;

    public Reservation(Showing showing, double price, List<Seat> reservedSeats, UserWithRoles user) {
        this.showing = showing;
        this.price = price;
        this.reservedSeats = reservedSeats;
        this.user = user;
    }
    public Reservation(){}


    public Reservation(Showing showing, String email, double price, List<Seat> seat) {
        this.showing = showing;
        this.price = price;
        this.reservedSeats = seat;
        this.email = email;
    }

    public Reservation(ReservationRequestDto reservationToAdd) {
        this.showing = reservationToAdd.getShowing();
        this.reservedSeats = reservationToAdd.getReservedSeats();
    }
}
