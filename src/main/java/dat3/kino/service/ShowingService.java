package dat3.kino.service;

import dat3.kino.entity.Reservation;
import dat3.kino.entity.Showing;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    ShowingRepository showingRepository;
    ReservationRepository reservationRepository;

    public ShowingService(ShowingRepository showingRepository , ReservationRepository reservationRepository) {
        this.showingRepository = showingRepository;
        this.reservationRepository = reservationRepository;
    }

    public Showing addShowing(Showing showingToAdd) {
        return showingRepository.save(showingToAdd);
    }

    public List<Showing> findAll() {
        return showingRepository.findAll();
    }

    public Showing findById(Long id) {
        return showingRepository.findById(id).orElse(null);
    }

    public Showing updateShowing(Showing showingToUpdate, Long id) {
        Showing showing = showingRepository.findById(id).orElse(null);
        if (showing == null) {
            return null;
        }
        showingToUpdate.setId( showing.getId());

        return showingRepository.save(showingToUpdate);
    }

    public void deleteShowing(Long id) {
        showingRepository.deleteById(id);
    }

    public List<Integer> getUnavailableSeats(Long id) {
        List<Reservation> foundReservations = reservationRepository.findAllByShowingId(id);
        List<Integer> unavailableSeats = foundReservations.stream()
                .map(Reservation::getSeatNumbers)
                .flatMap(List::stream)
                .toList();
        return unavailableSeats;
    }
}
