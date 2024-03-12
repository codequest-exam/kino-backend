package dat3.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reservation {

    @Id
    private Long id;

    private Showing show;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
