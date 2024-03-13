package dat3.kino.controllers;

import dat3.kino.service.ShowingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showings")
public class ShowingController {
    ShowingService showingService;

    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }
}
