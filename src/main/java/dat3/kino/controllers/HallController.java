package dat3.kino.controllers;

import dat3.kino.dto.HallResponseDto;
import dat3.kino.dto.SeatResponseDto;
import dat3.kino.entity.Hall;
import dat3.kino.service.HallService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {

    HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @Operation(summary = "Get all halls",
            description = "Returns a list of all halls",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all halls"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No halls found")})
    @GetMapping
    public List<HallResponseDto> getAllHalls() {
        return hallService.getAll();
    }

    @Operation(summary = "Get all seats for a hall",
            description = "Returns a list of all seats for a hall by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of all seats for a hall with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No hall found with given id")})
    @GetMapping("/{id}/seats")
    public List<SeatResponseDto> getSeatsForHall(@PathVariable Long id) {
        return hallService.getSeatsByHall(id);
    }

    @Operation(summary = "Get one hall by id",
            description = "Returns a hall by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A hall with given id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No hall found with given id")})
    @GetMapping(path = "/{id}")
    public Hall getHallById(@PathVariable Long id) {
        return hallService.findById(id);
    }
    @Operation(summary = "Get one hall by cinema id",
            description = "Returns a hall by cinema id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A hall with given cinema id"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "No hall found with given cinema id")})
    @GetMapping(path = "/cinema/{id}")
    public Hall getHallByCinemaId(@PathVariable Long id){
        return hallService.findByCinemaId(id);
    }

    @Operation(summary = "Create a hall",
            description = "Returns a hall after adding it to the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A hall has been created"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not create hall")})
    @PostMapping
    public Hall createHall(@RequestBody Hall newHall) {
        return hallService.addHall(newHall);
    }

    @Operation(summary = "Update a hall",
            description = "Returns a hall after updating it in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A hall has been updated"),
                    @ApiResponse(responseCode = "400", content = @Content, description = "Could not update hall")})
    @PutMapping(path = "/{id}")
    public Hall updateHall(@RequestBody Hall hallToUpdate, @PathVariable Long id) {
        return hallService.updateHall(hallToUpdate, id);
    }
}
