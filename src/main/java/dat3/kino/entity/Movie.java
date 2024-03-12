package dat3.kino.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    private int durationInSeconds;

    private boolean supports3d;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
//    private Set<Recipe> recipes;

    public Movie(String name, int durationInSeconds, boolean supports3d) {
        this.name = name;
        this.supports3d = supports3d;
        this.durationInSeconds = durationInSeconds;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public boolean isSupports3d() {
        return supports3d;
    }

    public void setSupports3d(boolean supports3d) {
        this.supports3d = supports3d;
    }
}
