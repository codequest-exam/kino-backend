package dat3.kino.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dat3.kino.api_facade.OmdbFacade;
import dat3.kino.dto.MovieOmdbResponse;
import dat3.kino.dto.MovieResponseDto;
import dat3.kino.entity.Cinema;
import dat3.kino.entity.Movie;
import dat3.kino.repository.CinemaRepository;
import dat3.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {


    MovieRepository movieRepository;

    @Autowired
    OmdbFacade omdbFacade;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movieToadd) {

        return movieRepository.save(movieToadd);
    }

    public List<MovieResponseDto> findAll() {
        return movieRepository.findAll().stream().map(MovieResponseDto::new).toList();
    }

    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbID(imdbId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }


    public Movie addMovie(String imdbId) throws JsonProcessingException {
        MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);

        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .year(dto.getYear())
                .rated(dto.getRated())
                .released(dto.getReleased())
                .runtime(dto.getRuntime())
                .genre(dto.getGenre())
                .director(dto.getDirector())
                .writer(dto.getWriter())
                .actors(dto.getActors())
                .metascore(dto.getMetascore())
                .imdbRating(dto.getImdbRating())
                .imdbVotes(dto.getImdbVotes())
                .website(dto.getWebsite())
                .response(dto.getResponse())
                .plot(dto.getPlot())
                .poster(dto.getPoster())
                .imdbID(dto.getImdbID())
                .build();
        try {
            movieRepository.save(movie);
            return movie;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add movie");
        }
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
