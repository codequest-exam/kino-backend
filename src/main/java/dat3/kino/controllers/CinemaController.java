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
    public List<Cinema> getCinema(){
        return cinemaService.getCinema();
    }

    @GetMapping
    public Cinema getCinemaById(Long id){
        return cinemaService.getCinemaById(id);
    }

    @PostMapping
    public Cinema addCinema(Cinema cinemaToAdd) {
        return cinemaService.addCinema(cinemaToAdd);
    }

    @PutMapping
    public Cinema updateCinema(Cinema cinemaToUpdate, Long id) {
        return cinemaService.updateCinema(cinemaToUpdate, id);
    }

}
