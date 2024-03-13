package dat3.kino.service;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Movie;
import dat3.kino.repository.CinemaRepository;
import dat3.kino.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movieToadd) {

        return movieRepository.save(movieToadd);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Movie movieToUpdate, Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return null;
        }
        movieToUpdate.setId( movie.getId());

        return movieRepository.save(movieToUpdate);
    }
}
