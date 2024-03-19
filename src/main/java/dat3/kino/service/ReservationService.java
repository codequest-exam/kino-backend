package dat3.kino.service;

import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.Reservation;
import dat3.kino.entity.Seat;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ShowingRepository showingRepository;

    public ReservationService(ReservationRepository reservationRepository, ShowingRepository showingRepository) {
        this.reservationRepository = reservationRepository;
        this.showingRepository = showingRepository;
    }

    public List<ReservationResponseDto> findAll() { return reservationRepository.findAll().stream().map(ReservationResponseDto::new).toList();}

    public ReservationResponseDto findById(Long id, Principal principal) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation does not exist"));
        if (principal != null && reservation.getUser() != null && !principal.getName().equals(reservation.getUser().getUsername())) {
            throw new IllegalArgumentException("You are not authorized to view this reservation");
        }
        return new ReservationResponseDto(reservation);
    }

    public ReservationResponseDto addReservation(Reservation reservationToAdd) {
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
        return new ReservationResponseDto(reservationRepository.save(reservationToAdd));
    }





    public List<ReservationResponseDto> findByShowingId(Long id) {
        return reservationRepository.findAllByShowingId(id).stream().map(ReservationResponseDto::new).toList();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
