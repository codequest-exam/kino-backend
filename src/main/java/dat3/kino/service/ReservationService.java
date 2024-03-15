package dat3.kino.service;

import dat3.kino.entity.Reservation;
import dat3.kino.entity.Seat;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.stereotype.Service;

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

        //            // Check if any of the seats are already reserved
        List<Reservation> reservations = reservationRepository.findAllByShowingId(showingId);

//        for (Reservation reservation : reservations) {
//            for (Seat seat : reservationToAdd.getReservedSeats()) {
//                if (reservation.getReservedSeats().contains(seat)) {
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
