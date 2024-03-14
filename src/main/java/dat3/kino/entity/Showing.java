package dat3.kino.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Hall hall;

    private int startTimeInSeconds;
    private int endTimeInSeconds;
    private boolean is3d;
    private boolean isImax;
    private double moviePrice;

    public Showing(Movie movie,
                   Hall hall,
                   int startTimeInSeconds, int endTimeInSeconds, boolean is3d, boolean isImax, double moviePrice) {
        this.movie = movie;
        this.hall = hall;
        this.startTimeInSeconds = startTimeInSeconds;
        this.endTimeInSeconds = endTimeInSeconds;
        this.is3d = is3d;
        this.isImax = isImax;
        this.moviePrice = moviePrice;
    }

    public Showing() {
    }




}
