package dat3.kino.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reservation {

    @Id
    private Long id;

    @ManyToOne
    private Showing show;

    private int price;

    //@Column
    //@OneToMany
    //private List<Integer> seatNumbers;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
