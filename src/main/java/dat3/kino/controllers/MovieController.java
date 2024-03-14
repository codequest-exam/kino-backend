package dat3.kino.controllers;

import dat3.kino.entity.Movie;
import dat3.kino.service.CinemaService;
import dat3.kino.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies/")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll(){
        return movieService.findAll();
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
