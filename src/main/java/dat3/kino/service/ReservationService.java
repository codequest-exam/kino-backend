package dat3.kino.service;

import dat3.kino.entity.Movie;
import dat3.kino.entity.Reservation;
import dat3.kino.repository.MovieRepository;
import dat3.kino.repository.ReservationRepository;

public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservationToAdd) {

        return reservationRepository.save(reservationToAdd);
    }
}
