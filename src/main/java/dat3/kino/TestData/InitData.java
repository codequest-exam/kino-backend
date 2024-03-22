package dat3.kino.TestData;

import dat3.kino.api_facade.OmdbFacade;
import dat3.kino.entity.*;
import dat3.kino.repository.*;
import dat3.kino.service.MovieService;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class InitData implements ApplicationRunner {


    private final MovieRepository movieRepository;

    private final HallRepository hallRepository;

    private final ShowingRepository showingRepository;

    private final CinemaRepository cinemaRepository;

    private final ReservationRepository reservationRepository;

    private final OmdbFacade omdbFacade;

    private final MovieService movieService;

    private final SeatRepository seatRepository;

    private final PriceClassRepository priceClassRepository;
    private final UserWithRolesRepository userWithRolesRepository;
    private final TicketPriceModifierRepository ticketPriceModifierRepository;
    @Autowired
    private MovieLengthCategoryRepository movieLengthCategoryRepository;
    @Autowired
    private GroupSizeCategoryRepository groupSizeCategoryRepository;


    public InitData(TicketPriceModifierRepository ticketPriceModifierRepository,
            UserWithRolesRepository userWithRolesRepository,
                    PriceClassRepository priceClassRepository,
                    SeatRepository seatRepository, ReservationRepository reservationRepository, MovieRepository movieRepository, HallRepository hallRepository, ShowingRepository showingRepository, CinemaRepository cinemaRepository, OmdbFacade omdbFacade, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.hallRepository = hallRepository;
        this.showingRepository = showingRepository;
        this.cinemaRepository = cinemaRepository;
        this.reservationRepository = reservationRepository;
        this.omdbFacade = omdbFacade;
        this.movieService = movieService;
        this.seatRepository = seatRepository;
        this.priceClassRepository = priceClassRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.ticketPriceModifierRepository = ticketPriceModifierRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupAll();
    }

    public void setupAll() {

        // List of IMDB IDs of movies to initialize
        List<String> imdbIds = List.of("tt0110912", "tt0137523", "tt0167260", "tt1375666", "tt0133093", "tt0080684", "tt0088763", "tt0172495","tt0347149", "tt0080678", "tt0107207", "tt0097165", "tt0103639", "tt0892769", "tt0198781", "tt1201607", "tt0081505", "tt4154796"); // Example IMDB IDs

        // Fetch movie details using OMDB API and add to the database
        //for (String imdbId : imdbIds) {
        // MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);

           for (String imdbId : imdbIds) {
//               //MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);
//
//               // Create a movie entity and add it to the database
               try {
                   movieService.addMovie(imdbId);
               } catch (Exception e) {
                   System.err.println("Failed to add movie with IMDB ID: " + imdbId);
                   e.printStackTrace();
               }
               }

        Movie movie1 = new Movie("The Godfather", "1972", "R", "24 Mar 1972", "175 min", "Crime, Drama", "Francis Ford Coppola", "Mario Puzo, Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", "The Godfather \\\"Don\\\" Vito Corleone is the head of the Corleone mafia family in New York. He is at the event of his daughter's wedding. Michael, Vito's youngest son and a decorated WW II Marine is also present at the wedding. Michael seems to be uninterested in being a part of the family business. Vito is a powerful man, and is kind to all those who give him respect but is ruthless against those who do not. But when a powerful and treacherous rival wants to sell drugs and needs the Don's influence for the same, Vito refuses to do it. What follows is a clash between Vito's fading old values and the new ways which may cause Michael to do the thing he was most reluctant in doing and wage a mob war against all the other mafia families which could tear the Corleone family apart.", null, "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "100", "9.2", "1,997,580", "tt006846", "N/A", "True", false);
        Movie movie2 = new Movie("Dune: Part Two", "2024", "Pg-13", "01 Mar 2024", "166 min", "Action, Adventure, Drama", "Denis Villeneuve", "Dennis Villeneuve, Jon Spaiths, Frank Herbert", "Timothée Chalamet, Rebecca Ferguson, Zendaya", "Duke Paul Atreides joins the Fremen and begins a spiritual and martial journey to become Muad'dib, while trying to prevent the horrible but inevitable future he's witnessed: a Holy War in his name, spreading throughout the known universe.", null, "https://m.media-amazon.com/images/M/MV5BODdjMjM3NGQtZDA5OC00NGE4LWIyZDQtZjYwOGZlMTM5ZTQ1XkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg", "N/A", "9.1", "16,829", "tt1160419", "N/A", "True", false);
//              Movie movie3 = new Movie("The Godfather", 175 * 60, false);
//              Movie movie4 = new Movie("The Dark Knight", 152 * 60, true);
//              Movie movie5 = new Movie("Pulp Fiction", 154 * 60, false);
//              Movie movie6 = new Movie("Forrest Gump", 142 * 60, false);
//              Movie movie7 = new Movie("The Matrix", 136 * 60, true);
//              Movie movie8 = new Movie("The Lord of the Rings: The Fellowship of the Ring", 178 * 60, true);
//              Movie movie9 = new Movie("Fight Club", 139 * 60, false);
//              Movie movie10 = new Movie("The Silence of the Lambs", 118 * 60, false);

        movieRepository.saveAll(Arrays.asList(movie1, movie2
                // , movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10
        ));

        Cinema cinema1 = new Cinema("Cineplex Odeon", "123 Main Street");
        Cinema cinema2 = new Cinema("AMC Theatres", "456 Elm Street");

        cinemaRepository.save(cinema1);
        cinemaRepository.save(cinema2);

        //Creating cinema halls for cinema 1
        Hall hall1 = new Hall(cinema1, 1, true, false, 20, 15);
        Hall hall2 = new Hall(cinema1, 2, true, true, 22, 12);

        // Creating cinema halls for cinema 2
        Hall hall3 = new Hall(cinema2, 1, false, false, 21, 16);
        Hall hall5 = new Hall(cinema2, 3, true, false, 23, 13);
        Hall hall4 = new Hall(cinema2, 2, true, true, 24, 14);
        Hall hall6 = new Hall(cinema2, 4, false, true, 25, 11);

        // Saving cinema halls to the repository
        hallRepository.save(hall1);
        hallRepository.save(hall2);
        hallRepository.save(hall3);
        hallRepository.save(hall4);
        hallRepository.save(hall5);
        hallRepository.save(hall6);
//
        // Creating showings for cinema 1, hall 1

        // Creating showings for cinema 1, hall 1
        Showing showing1 = new Showing(movie1, hall1, LocalDateTime.of(2024, 3, 14, 10, 0), true, false);
        Showing showing2 = new Showing(movie2, hall1, LocalDateTime.of(2024, 4, 15, 10, 0), true, false);

        // Creating showings for cinema 1, hall 2
        Showing showing3 = new Showing(movie2, hall2, LocalDateTime.of(2024, 2, 16, 11, 0), false, true);
        Showing showing4 = new Showing(movie1, hall2, LocalDateTime.of(2024, 5, 18, 14, 0), false, false);
//
//              // Creating showings for cinema 2, hall 1
//              Showing showing5 = new Showing(movie5, hall3, 0, 7200, true, false, 12.0);
//              Showing showing6 = new Showing(movie6, hall3, 0, 7200, true, true, 15.0);
//
//              // Creating showings for cinema 2, hall 2
//              Showing showing7 = new Showing(movie7, hall4, 0, 7200, false, true, 10.0);
//              Showing showing8 = new Showing(movie8, hall4, 3600, 10800, true, true, 18.0);

        // Saving showings to the repository
        showingRepository.saveAll(Arrays.asList(showing1, showing2,
                showing3, showing4
                //showing5, showing6, showing7, showing8
        ));
        // initialize seats for hall1 to be added through a loop cannot be null
        // HashMap<Integer, Seat> seats;

        //price classes
        PriceClass priceClass1 = new PriceClass("standard", 100);
        PriceClass priceClass2 = new PriceClass("cowboy", 80);
        PriceClass priceClass3 = new PriceClass("sofa", 125);
        PriceClass priceClass4 = new PriceClass("showingIs3d", 25);
        PriceClass priceClass5 = new PriceClass("showingIsImax", 30);

        TicketPriceModifier priceModifier = new TicketPriceModifier("groupDiscount", 0.93);
        TicketPriceModifier priceModifier2 = new TicketPriceModifier("allNight", 1.1);
        TicketPriceModifier priceModifier3 = new TicketPriceModifier("shortFilm", 0.8);
        TicketPriceModifier priceModifier4 = new TicketPriceModifier("reservationFee", 1.03);

        MovieLengthCategory allNight = new MovieLengthCategory("allNight",170, 999);
        MovieLengthCategory shortFilm = new MovieLengthCategory("shortFilm",0, 60);

        GroupSizeCategory groupDiscount = new GroupSizeCategory("groupDiscount", 10, 999);
        GroupSizeCategory reservationFee = new GroupSizeCategory("reservationFee", 1, 5);



        priceClassRepository.saveAll(Arrays.asList(priceClass1, priceClass2, priceClass3, priceClass4, priceClass5));
        ticketPriceModifierRepository.saveAll(Arrays.asList(priceModifier, priceModifier2, priceModifier3, priceModifier4));
        movieLengthCategoryRepository.saveAll(Arrays.asList(allNight, shortFilm));
        groupSizeCategoryRepository.saveAll(Arrays.asList(groupDiscount, reservationFee));


        //loop through all the halls
        for (Hall hall : hallRepository.findAll()) {
            // loop through all the seats in the hall
            List<Seat> seats = new ArrayList<>();
            for (int i = 0; i < hall.getSeatRows() * hall.getSeatsPerRow(); i++) {
                // add seats to the hall through a loop, save them all at the end
                // row rounded down to the nearest integer
                int row = (int) Math.floor(i / hall.getSeatsPerRow()) + 1;
                PriceClass price = row < 3 ? priceClass2 : row > hall.getSeatRows() - 2 ? priceClass3 : priceClass1;
                seats.add(new Seat(hall, i + 1, row, price));

            }
            seatRepository.saveAll(seats);
        }
//
//
        //make reservation with a list of unique seat numbers
        Seat seat1 = seatRepository.findById(1L).orElseThrow(() -> new RuntimeException("Seat not found"));
        Seat seat2 = seatRepository.findById(2L).orElseThrow(() -> new RuntimeException("Seat not found"));
        Seat seat3 = seatRepository.findById(3L).orElseThrow(() -> new RuntimeException("Seat not found"));
        Seat seat4 = seatRepository.findById(4L).orElseThrow(() -> new RuntimeException("Seat not found"));
        System.out.println(seat1 + " " + seat2 + " " + seat3 + " " + seat4);

//        UserWithRoles user = userWithRolesRepository.findById("user1").orElseThrow(() -> new RuntimeException("User not found"));
//
        Reservation reservation1 = new Reservation(showing1, "bingchilling@gmail.com", 100, List.of(seat1));
        Reservation reservation2 = new Reservation(showing2, "romania@gmail.com", 200, List.of(seat2));

        Reservation reservation3 = new Reservation(showing3, "russia@gmail.com", 300, List.of(seat3));
        Reservation reservation4 = new Reservation(showing4, "albania@gmail.com", 400, List.of(seat4));

        //     save the reservations
        reservationRepository.saveAll(Arrays.asList(reservation1, reservation2,
                reservation3, reservation4
        ));
    }
}

