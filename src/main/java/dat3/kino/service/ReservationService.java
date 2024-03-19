package dat3.kino.service;

import com.nimbusds.jose.proc.SecurityContext;
import dat3.kino.dto.ReservationRequestDto;
import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.Reservation;
import dat3.kino.entity.Seat;
import dat3.kino.entity.Showing;
import dat3.kino.repository.HallRepository;
import dat3.kino.repository.ReservationRepository;
import dat3.kino.repository.SeatRepository;
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
    HallRepository hallRepository;
    SeatRepository seatRepository;

    public ReservationService(UserWithRolesRepository userWithRolesRepository, ReservationRepository reservationRepository, ShowingRepository showingRepository, HallRepository hallRepository, SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.showingRepository = showingRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.hallRepository = hallRepository;
        this.seatRepository = seatRepository;
    }

    public List<ReservationResponseDto> findAll() {
        return reservationRepository.findAll().stream().map(ReservationResponseDto::new).toList();
    }

    public Reservation findById(Long id, Principal principal) {
        //public ReservationResponseDto findById(Long id, Principal principal) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation does not exist"));
        //only run the check if the user has the CUSTOMER role

        //System.out.println(principal.getName() + " " + reservation.getUser().getUsername() + " " + isCustomer);
        if (isCustomer() && !principal.getName().equals(reservation.getUser().getUsername())) {
            throw new IllegalArgumentException("You can only see the details of your own reservations");
        }

        return reservation;
        //return new ReservationResponseDto(reservation);
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

        Showing showing = showingRepository.findById(reservation.getShowing().getId()).orElseThrow(() -> new IllegalArgumentException("Showing does not exist"));

        List<Seat> seats = reservation.getReservedSeats();
        List<Seat> correctSeats = seatRepository.findAllByHallId(showing.getHall().getId());
        System.out.println(correctSeats.size() + " " + seats.size());

        double totalPrice = 0;

        for (Seat seat : seats) {
            System.out.println("SEAT " + seat);
            // find the seat in the correctSeats list
            // add the price to the total price

            boolean seatCheck = correctSeats.stream().map(Seat::getId).anyMatch(s -> s.equals(seat.getId()));
            if (!seatCheck) {throw new IllegalArgumentException("Seat does not exist in this hall");}
            System.out.println("PRICE CLASS " + seat.getPriceClass());

            //get the price class from the seat
            //getPriceClass() is undefined


            //totalPrice += seat.getPriceClass().getPrice();
        }

        if (seats.size() > 8) {
            totalPrice = totalPrice * 0.9;
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Run time " + showing.getMovie().getRuntime());
        // check the return type of getRunTime
//        if (showing.getMovie().getRuntime() > 170)

        reservation.setPrice(totalPrice);

        // set the user
        if (principal != null) {
            Optional<UserWithRoles> userCheck = userWithRolesRepository.findById(principal.getName());
            if (userCheck.isPresent()) {
                reservation.setUser(userCheck.get());
            } else {
                throw new IllegalArgumentException("User does not exist");
            }
        }
        // phone number is required if user is not logged in - so make sure it's present in the request
        else {
            if (reservation.getPhoneNumber() == 0) {
                throw new IllegalArgumentException("Phone number is required when user is not logged in");
            }
        }


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
