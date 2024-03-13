package dat3.kino.controllers;

import dat3.kino.entity.Cinema;
import dat3.kino.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<Cinema> getCinemas(){
        return cinemaService.getCinemas();
    }

    @GetMapping(path = "/{id}")
    public Cinema getCinemaById(@PathVariable Long id){
        return cinemaService.getCinemaById(id);
    }

    @PostMapping
    public Cinema addCinema(@RequestBody Cinema cinemaToAdd) {
        return cinemaService.addCinema(cinemaToAdd);
    }

    @PutMapping(path = "/{id}")
    public Cinema updateCinema(@RequestBody Cinema cinemaToUpdate, @PathVariable Long id) {
        return cinemaService.updateCinema(cinemaToUpdate, id);
    }

}
