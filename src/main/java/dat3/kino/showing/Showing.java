package dat3.kino.showing;

import com.fasterxml.jackson.annotation.JsonProperty;
import dat3.kino.movie.Movie;
import dat3.kino.hall.Hall;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


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
    private LocalDateTime startTime;
    @JsonProperty("is3d")
    private boolean is3d;
    @JsonProperty("isImax")
    private boolean isImax;

    public Showing(Movie movie,
                   Hall hall, LocalDateTime startTime, boolean is3d, boolean isImax) {
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.is3d = is3d;
        this.isImax = isImax;
    }

    public Showing() {
    }
}
