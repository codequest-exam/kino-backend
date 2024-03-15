package dat3.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue
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
