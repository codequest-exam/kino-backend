package dat3.kino.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDto {
    private Long id;
    private String title;
    private String imdbRating;
    private String poster;
    private String genre;
    private String year;
    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.imdbRating = movie.getImdbRating();
        this.poster = movie.getPoster();
        this.genre = movie.getGenre();
        this.year = movie.getYear();
    }
}
