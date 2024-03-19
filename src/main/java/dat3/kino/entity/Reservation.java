package dat3.kino.entity;

import dat3.kino.dto.ReservationRequestDto;
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

    private int phoneNumber;

    @NotNull
    @OneToMany
    private List<Seat> reservedSeats;

    public Reservation(Showing showing, double price, List<Seat> reservedSeats, UserWithRoles user) {
        this.showing = showing;
        this.price = price;
        this.reservedSeats = reservedSeats;
        this.user = user;
    }
    public Reservation(){}


    public Reservation(Showing showing, double price, List<Seat> seat) {
        this.showing = showing;
        this.price = price;
        this.reservedSeats = seat;
    }

    public Reservation(ReservationRequestDto reservationToAdd) {
        this.showing = reservationToAdd.getShowing();
        this.reservedSeats = reservationToAdd.getReservedSeats();
    }
}
