package dat3.kino.service;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Movie;
import dat3.kino.repository.CinemaRepository;
import dat3.kino.repository.MovieRepository;

public class MovieService {


    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movieToadd) {

        return movieRepository.save(movieToadd);
    }
}
