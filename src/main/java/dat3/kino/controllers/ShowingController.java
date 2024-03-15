package dat3.kino.controllers;

import dat3.kino.entity.Showing;
import dat3.kino.service.ShowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showings/")
public class ShowingController {
    ShowingService showingService;

    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @GetMapping(path = "{id}/takenSeats")
    public List<Integer> getUnavailableSeats(@PathVariable Long id){
        return showingService.getUnavailableSeats(id);
    }

    @GetMapping
    public List<Showing> getAllShowings(){
        return showingService.findAll();
    }

    @GetMapping(path = "{id}")
    public Showing getShowingById(@PathVariable Long id){
        return showingService.findById(id);
    }

    @PostMapping
    public Showing addShowing(@RequestBody Showing showingToAdd){
        return showingService.addShowing(showingToAdd);
    }

    @PutMapping(path = "{id}")
    public Showing updateShowing(@RequestBody Showing showingToUpdate, @PathVariable Long id){
        return showingService.updateShowing(showingToUpdate, id);
    }


    @DeleteMapping(path = "{id}")
    public void deleteShowing(@PathVariable Long id){
        showingService.deleteShowing(id);
    }
}
