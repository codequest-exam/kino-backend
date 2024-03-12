package dat3.kino.service;

import dat3.kino.entity.Cinema;
import dat3.kino.repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema addCinema(Cinema cinemaToAdd) {

        return cinemaRepository.save(cinemaToAdd);
    }
}
