package dat3.kino.entity;


import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;




=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
>>>>>>> cfd6de9 (CK-36 adjusted InitData to match updated movie entity)

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "movies")
public class Movie {

    @Column(unique = true)
    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;

    @Column(length = 2000)
    private String plot;
    @Column(length = 2000)
    private String plotDK;
    private String poster;

    private String metascore;
    private String imdbRating;
    private String imdbVotes;

    @Column(unique = true)
    private String imdbID;
    private String website;
    private String response;
    private boolean supports3d;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
//    private Set<Recipe> recipes;

    public Movie(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String plotDK, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String website, String response, boolean supports3d) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.plotDK = plotDK;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.website = website;
        this.response = response;
        this.supports3d = supports3d;
    }
    }
