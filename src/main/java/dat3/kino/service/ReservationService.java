package dat3.kino.service;

import dat3.kino.entity.Movie;
import dat3.kino.entity.Reservation;
import dat3.kino.repository.MovieRepository;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ShowingRepository showingRepository;

    public ReservationService(ReservationRepository reservationRepository, ShowingRepository showingRepository) {
        this.reservationRepository = reservationRepository;
        this.showingRepository = showingRepository;
    }

    public Reservation addReservation(Reservation reservationToAdd) {
        Long showingId = reservationToAdd.getShowing().getId();
        if (showingRepository.findById(showingId).isEmpty()) {
            throw new IllegalArgumentException("Showing does not exist");
        }

        List<Reservation> reservations = reservationRepository.findAllByShowingId(showingId);
//        for (Reservation reservation : reservations) {
//
//            // Check if any of the seats are already reserved
//            for (Integer seatNumber : reservationToAdd.getSeatNumbers()) {
//                if (reservation.getSeatNumbers().contains(seatNumber)) {
//                    throw new IllegalArgumentException("Seat is already reserved");
//                }
//            }
//        }
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
