package dat3.kino.service;

import com.nimbusds.jose.proc.SecurityContext;
import dat3.kino.dto.ReservationRequestDto;
import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.Reservation;
import dat3.kino.entity.Seat;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.ShowingRepository;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ShowingRepository showingRepository;
    UserWithRolesRepository userWithRolesRepository;

    public ReservationService(UserWithRolesRepository userWithRolesRepository, ReservationRepository reservationRepository, ShowingRepository showingRepository) {
        this.reservationRepository = reservationRepository;
        this.showingRepository = showingRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }

    public List<ReservationResponseDto> findAll() {
        return reservationRepository.findAll().stream().map(ReservationResponseDto::new).toList();
    }

    public ReservationResponseDto findById(Long id, Principal principal) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation does not exist"));
        //only run the check if the user has the CUSTOMER role

        //System.out.println(principal.getName() + " " + reservation.getUser().getUsername() + " " + isCustomer);
        if (isCustomer() && !principal.getName().equals(reservation.getUser().getUsername())) {
            throw new IllegalArgumentException("You can only see the details of your own reservations");
        }

        return new ReservationResponseDto(reservation);
    }


    public List<ReservationResponseDto> findByShowingId(Long id) {
        return reservationRepository.findAllByShowingId(id).stream().map(ReservationResponseDto::new).toList();
    }


    public List<ReservationResponseDto> findByUsername(UserWithRoles user, Principal principal) {

        if (isCustomer() && principal != null && !principal.getName().equals(user.getUsername())) {
            throw new IllegalArgumentException("You can only see your own reservations");
        }
        return reservationRepository.findAllByUser(user).stream().map(ReservationResponseDto::new).toList();
    }

    public Reservation addReservation(Reservation reservation, Principal principal) {
    //public ReservationResponseDto addReservation(Reservation reservation, Principal principal) {
    //public ReservationRequestDto addReservation(ReservationRequestDto dto, Principal principal) {

        //Reservation reservation = new Reservation(dto);
        Optional<UserWithRoles> userCheck = userWithRolesRepository.findById(principal.getName());

        if (userCheck.isEmpty()) {
            // if phonenumber is null, throw error
            if (reservation.getPhoneNumber() == 0) {
                throw new IllegalArgumentException("Phone number is required when user is not logged in");
            }
        }
        else if(userCheck.isPresent()) {
            reservation.setUser(userCheck.get());
        }
        Long showingId = reservation.getShowing().getId();
        //Long showingId = dto.getShowing().getId();

        if (showingRepository.findById(showingId).isEmpty()) {
            throw new IllegalArgumentException("Showing does not exist");
        }

        //            // Check if any of the seats are already reserved
//        List<Reservation> reservations = reservationRepository.findAllByShowingId(showingId);

//        for (Reservation reservation : reservations) {
//            for (Seat seat : reservationToAdd.getReservedSeats()) {
//                if (reservation.getReservedSeats().contains(seat)) {
//                    throw new IllegalArgumentException("Seat is already reserved");
//                }
//            }
//        }
        return reservationRepository.save(reservation);
        //return new ReservationResponseDto(reservationRepository.save(reservation));
    }


    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    private boolean isCustomer() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CUSTOMER"));
    }

}
