package dat3.kino.seat;

import dat3.kino.hall.Hall;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Hall hall;
    private int seatNumber;
    private int seatRowNumber;
    @ManyToOne
    private PriceClass priceClass;


    public Seat(Hall hall, int seatNumber, int seatRow, PriceClass priceClass) {
        this.hall = hall;
        this.seatNumber = seatNumber;
        this.seatRowNumber = seatRow;
        this.priceClass = priceClass;
    }
}
