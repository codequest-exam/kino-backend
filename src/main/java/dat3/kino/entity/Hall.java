package dat3.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
//@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cinema cinema;

    private int roomNumber;
    private boolean supports3d;
    private boolean supportsImax;
    private int seatRows;
    private int seatsPerRow;

    public Hall() {
    }

    public Hall(Cinema cinema, int roomNumber, boolean supports3d, boolean supportsImax, int seatRows, int seatsPerRow) {
        this.cinema = cinema;
        this.roomNumber = roomNumber;
        this.supports3d = supports3d;
        this.supportsImax = supportsImax;
        this.seatRows = seatRows;
        this.seatsPerRow = seatsPerRow;
    }

    public int getTotalSeats() {
        return seatRows * seatsPerRow;
    }
}
