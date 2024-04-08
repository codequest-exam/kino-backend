package dat3.kino.cinema;

import dat3.kino.cinema.Cinema;
import dat3.kino.cinema.CinemaService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Cinema API",
                version = "1.0",
                description = "Dokumentation for RestfulKino API af codeQuest"
        )

)

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Operation(summary = "Get all cinemas",
            description = "Returns a list of all cinemas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all cinemas"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No cinemas found")})
    @GetMapping
    public List<Cinema> getCinemas(){
        return cinemaService.getCinemas();
    }

    @Operation(summary = "Get one cinema by id",
            description = "Returns a cinema by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A cinema with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No cinema found with given id")})
    @GetMapping(path = "/{id}")
    public Cinema getCinemaById(@PathVariable Long id){
        return cinemaService.getCinemaById(id);
    }

    @Operation(summary = "Add a cinema",
            description = "Returns a cinema after adding it to the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A cinema has been added"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not add cinema")})
    @PostMapping
    public Cinema addCinema(@RequestBody Cinema cinemaToAdd) {
        return cinemaService.addCinema(cinemaToAdd);
    }

    @Operation(summary = "Update a cinema",
            description = "Updates a cinema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A cinema has been deleted"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not delete cinema")})
    @PutMapping(path = "/{id}")
    public Cinema updateCinema(@RequestBody Cinema cinemaToUpdate, @PathVariable Long id) {
        return cinemaService.updateCinema(cinemaToUpdate, id);
    }

}
