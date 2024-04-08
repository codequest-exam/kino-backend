package dat3.kino.showing;

import dat3.kino.reservation.Reservation;
import dat3.kino.seat.Seat;
import dat3.kino.reservation.ReservationRepository;
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

    public List<ShowingResponseDto> findAll() {
        return showingRepository.findAll().stream().map(ShowingResponseDto::new).toList();
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
                .map(Reservation::getReservedSeats)
                .flatMap(List::stream)
                .map(Seat::getSeatNumber)
                .toList();
        return unavailableSeats;
    }

    public List<ShowingResponseDto> findAllByMovie(Long id) {
        return showingRepository.findAllByMovieId(id).stream().map(ShowingResponseDto::new).toList();
    }
}
