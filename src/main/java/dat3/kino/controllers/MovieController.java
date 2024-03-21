package dat3.kino.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import dat3.kino.dto.MovieResponseDto;
import dat3.kino.entity.Movie;
import dat3.kino.service.CinemaService;
import dat3.kino.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Get all movies",
            description = "Returns a list of all movies",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all movies"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No movies found")})
    @GetMapping
    public List<MovieResponseDto> getAll(){
        return movieService.findAll();
    }

    @Operation(summary = "Get one movie by imdbId",
            description = "Returns a movie by imdbId",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A movie with given imdbId"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No movie found with given imdbId")})
    @RequestMapping("/imdbid/{imdbId}")
    public Movie getMovie(@PathVariable String imdbId) {
        return movieService.getMovieByImdbId(imdbId);
    }

    @Operation(summary = "Add a movie",
            description = "Adds a movie",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A movie has been added"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not add movie")})
    @PostMapping("/{imdbId}")
    public Movie addMovie(@PathVariable String imdbId) throws JsonProcessingException {
        return movieService.addMovie(imdbId);
    }

    @Operation(summary = "Get one movie by id",
            description = "Returns a movie by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A movie with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No movie found with given id")})
    @GetMapping(path = "{id}")
    public Movie getById(@PathVariable Long id){
        return movieService.findById(id);
    }

//    @PostMapping
//    public Movie addMovie(@RequestBody Movie movieToAdd) {
//        return movieService.addMovie(movieToAdd);
//    }

    @Operation(summary = "Update a movie",
            description = "Returns a movie after updating",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A movie has been updated"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not update movie")})
    @PutMapping(path = "{id}")
    public Movie updateMovie(@RequestBody Movie movieToUpdate, @PathVariable Long id) {
        return movieService.updateMovie(movieToUpdate, id);
    }
}
