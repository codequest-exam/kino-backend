package dat3.kino.service;

import dat3.kino.entity.Movie;
import dat3.kino.entity.Reservation;
import dat3.kino.repository.MovieRepository;
import dat3.kino.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservationToAdd) {

        return reservationRepository.save(reservationToAdd);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> findByShowingId(Long id) {
        return reservationRepository.findAllByShowingId(id);
    }
}
