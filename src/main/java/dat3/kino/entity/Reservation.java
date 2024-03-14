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

    @ElementCollection
    @CollectionTable(name = "seat_numbers", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name = "seat_number")
    @NotNull
    private List<Integer> seatNumbers;

    public Reservation(Showing showing, int price, List<Integer> seatNumbers) {
        this.showing = showing;
        this.price = price;
        this.seatNumbers = seatNumbers;
    }
    public Reservation(){}


}
