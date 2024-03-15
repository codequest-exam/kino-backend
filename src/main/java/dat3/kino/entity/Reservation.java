package dat3.kino.entity;

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
    private int price;

    @NotNull
    @OneToMany
    private List<Seat> reservedSeats;

    public Reservation(Showing showing, int price, List<Seat> reservedSeats) {
        this.showing = showing;
        this.price = price;
        this.reservedSeats = reservedSeats;
    }
    public Reservation(){}


}
