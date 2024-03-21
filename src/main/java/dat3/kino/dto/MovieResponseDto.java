package dat3.kino.dto;

import dat3.kino.entity.Movie;
import dat3.kino.entity.Showing;
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
