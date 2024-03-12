package dat3.kino.entity;

import jakarta.persistence.*;

@Entity
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Room room;

    private int startTimeInSeconds;
    private int endTimeInSeconds;
    private boolean is3d;
    private boolean isImax;
    private float moviePrice;

    public Showing(Long id, Movie movie, Room room, int startTimeInSeconds, int endTimeInSeconds, boolean is3d, boolean isImax, float moviePrice) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.startTimeInSeconds = startTimeInSeconds;
        this.endTimeInSeconds = endTimeInSeconds;
        this.is3d = is3d;
        this.isImax = isImax;
        this.moviePrice = moviePrice;
    }

    public Showing() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getStartTimeInSeconds() {
        return startTimeInSeconds;
    }

    public void setStartTimeInSeconds(int startTimeInSeconds) {
        this.startTimeInSeconds = startTimeInSeconds;
    }

    public int getEndTimeInSeconds() {
        return endTimeInSeconds;
    }

    public void setEndTimeInSeconds(int endTimeInSeconds) {
        this.endTimeInSeconds = endTimeInSeconds;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }

    public boolean isImax() {
        return isImax;
    }

    public void setImax(boolean imax) {
        isImax = imax;
    }

    public float getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(float moviePrice) {
        this.moviePrice = moviePrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
