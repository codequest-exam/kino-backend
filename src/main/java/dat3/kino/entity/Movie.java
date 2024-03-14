package dat3.kino.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private int durationInSeconds;
    private boolean supports3d;

    public Movie(String name, int durationInSeconds, boolean supports3d) {
        this.name = name;
        this.supports3d = supports3d;
        this.durationInSeconds = durationInSeconds;
    }

}
