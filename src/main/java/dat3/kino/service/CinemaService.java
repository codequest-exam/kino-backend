package dat3.kino.service;

import dat3.kino.entity.Cinema;
import dat3.kino.repository.CinemaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class CinemaService {

    CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema addCinema(Cinema cinemaToAdd) {

        return cinemaRepository.save(cinemaToAdd);
    }

    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    public Cinema updateCinema(Cinema cinemaToUpdate, Long id) {
        if (!Objects.equals(cinemaToUpdate.getId(), id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing recipe");
        }

        Cinema cinemaToEdit = cinemaRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));

        cinemaToEdit.setName(cinemaToUpdate.getName());
        cinemaToEdit.setAddress(cinemaToUpdate.getAddress());

        return cinemaRepository.save(cinemaToEdit);
    }
}
