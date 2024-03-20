package dat3.kino.service;

import com.nimbusds.jose.proc.SecurityContext;
import dat3.kino.dto.ReservationRequestDto;
import dat3.kino.dto.ReservationResponseDto;
import dat3.kino.entity.*;
import dat3.kino.repository.*;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ShowingRepository showingRepository;
    UserWithRolesRepository userWithRolesRepository;
    HallRepository hallRepository;
    SeatRepository seatRepository;
    TicketPriceModifierRepository ticketPriceModifierRepository;
    @Autowired
    PriceClassRepository priceClassRepository;
    @Autowired
    MovieLengthCategoryRepository movieLengthCategoryRepository;

    public ReservationService(TicketPriceModifierRepository ticketPriceModifierRepository,
            UserWithRolesRepository userWithRolesRepository, ReservationRepository reservationRepository, ShowingRepository showingRepository, HallRepository hallRepository, SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.showingRepository = showingRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.hallRepository = hallRepository;
        this.seatRepository = seatRepository;
        this.ticketPriceModifierRepository = ticketPriceModifierRepository;
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
        // set the user

        System.out.println("PRINCIPAL " + principal);
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
            if (reservation.getEmail() == null) {
                throw new IllegalArgumentException("Email is required when user is not logged in");
            }
        }

        Showing showing = showingRepository.findById(reservation.getShowing().getId()).orElseThrow(() -> new IllegalArgumentException("Showing does not exist"));

        List<Seat> seats = reservation.getReservedSeats();

        double totalPrice = 0;
        double movie3dPrice = 0;
        double movieImaxPrice = 0;
        if (showing.is3d()) {
            movie3dPrice = priceClassRepository.findById("showingIs3d").orElseThrow(() -> new IllegalArgumentException("Price class does not exist")).getPrice();
        }
        if (showing.isImax()){
            movieImaxPrice = priceClassRepository.findById("showingIsImax").orElseThrow(() -> new IllegalArgumentException("Price class does not exist")).getPrice();
        }

        for (Seat seatToLookFor : seats) {
            //System.out.println("SEAT " + seatToLookFor);
            Seat correctSeat = seatRepository.findById(seatToLookFor.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat does not exist"));
            // Check if the seat exists in the hall
            if (!Objects.equals(correctSeat.getHall().getId(), showing.getHall().getId())) {
                throw new IllegalArgumentException("Seat does not exist in this hall");
            }

            totalPrice += correctSeat.getPriceClass().getPrice() + movie3dPrice + movieImaxPrice;
        }



        if (seats.size() > 8) {
            totalPrice = totalPrice * 0.9;
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Run time " + showing.getMovie().getRuntime());

        // check if the movies run time is longer than
        List<MovieLengthCategory> lengthCategories =  movieLengthCategoryRepository.findAll();

        // get the runtime from a string
        int runTime = Integer.parseInt(showing.getMovie().getRuntime().split(" ")[0]);

        for (MovieLengthCategory category : lengthCategories) {
            if (runTime < category.getMaxMinutes() && runTime > category.getMinMinutes()) {
                TicketPriceModifier priceModifier = ticketPriceModifierRepository.findById(category.getName()).orElseThrow(() -> new IllegalArgumentException("Price modifier does not exist"));
                totalPrice = priceModifier.isPositive() ? totalPrice * priceModifier.getPriceModifierPercent() : totalPrice / priceModifier.getPriceModifierPercent();
            }
        }
        //if (showing.getMovie().getRuntime().split(" "))

        reservation.setPrice(totalPrice);




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
