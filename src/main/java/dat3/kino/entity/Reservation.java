package dat3.kino.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Reservation {

    @Id
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

    public Reservation(Long id, Showing showing, int price, List<Integer> seatNumbers) {
        this.id = id;
        this.showing = showing;
        this.price = price;
        this.seatNumbers = seatNumbers;
    }
    public Reservation(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing show) {
        this.showing = show;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
