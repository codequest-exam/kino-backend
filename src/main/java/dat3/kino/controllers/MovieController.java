package dat3.kino.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import dat3.kino.dto.MovieResponseDto;
import dat3.kino.entity.Movie;
import dat3.kino.service.CinemaService;
import dat3.kino.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponseDto> getAll(){
        return movieService.findAll();
    }

    @RequestMapping("/imdbid/{imdbId}")
    public Movie getMovie(@PathVariable String imdbId) {
        return movieService.getMovieByImdbId(imdbId);
    }

    @PostMapping("/{imdbId}")
    public Movie addMovie(@PathVariable String imdbId) throws JsonProcessingException {
        return movieService.addMovie(imdbId);
    }

    @GetMapping(path = "{id}")
    public Movie getById(@PathVariable Long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movieToAdd) {
        return movieService.addMovie(movieToAdd);
    }

    @PutMapping(path = "{id}")
    public Movie updateMovie(@RequestBody Movie movieToUpdate, @PathVariable Long id) {
        return movieService.updateMovie(movieToUpdate, id);
    }
}
