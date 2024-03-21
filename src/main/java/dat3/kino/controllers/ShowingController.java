package dat3.kino.controllers;

import dat3.kino.dto.ShowingResponseDto;
import dat3.kino.entity.Showing;
import dat3.kino.service.ShowingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showings")
public class ShowingController {
    ShowingService showingService;

    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @Operation(summary = "Get unavailable seats",
            description = "Returns a list of all unavailable seats for a showing by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all unavailable seats for a showing with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No showing found with given id")})
    @GetMapping(path = "/{id}/takenSeats")
    public List<Integer> getUnavailableSeats(@PathVariable Long id){
        return showingService.getUnavailableSeats(id);
    }

    @Operation(summary = "Get all showings",
            description = "Returns a list of all showings",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all showings"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No showings found")})
    @GetMapping
    public List<ShowingResponseDto> getAllShowings(){
        return showingService.findAll();
    }

    @Operation(summary = "Get one showing by id",
            description = "Returns a showing by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A showing with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No showing found with given id")})
    @GetMapping(path = "/{id}")
    public Showing getShowingById(@PathVariable Long id){
        return showingService.findById(id);
    }

    @Operation(summary = "Add a showing",
            description = "Returns a showing after adding it to the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A showing has been added"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not add showing")})
    @PostMapping
    public Showing addShowing(@RequestBody Showing showingToAdd){
        return showingService.addShowing(showingToAdd);
    }

    @Operation(summary = "Update a showing",
            description = "Returns a showing after updating it in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A showing has been updated"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not update showing")})
    @PutMapping(path = "/{id}")
    public Showing updateShowing(@RequestBody Showing showingToUpdate, @PathVariable Long id){
        return showingService.updateShowing(showingToUpdate, id);
    }

    @Operation(summary = "Delete a showing",
            description = "Deletes a showing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A showing has been deleted"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not delete showing")})
    @DeleteMapping(path = "/{id}")
    public void deleteShowing(@PathVariable Long id){
        showingService.deleteShowing(id);
    }
}
