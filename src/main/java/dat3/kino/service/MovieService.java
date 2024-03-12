package dat3.kino.service;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Movie;
import dat3.kino.repository.CinemaRepository;
import dat3.kino.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {


    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movieToadd) {

        return movieRepository.save(movieToadd);
    }
}
