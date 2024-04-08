package dat3.kino.pricing;

import dat3.kino.seat.Seat;
import dat3.kino.showing.Showing;

public interface PricingStrategy {
    double getBasicSeatPrice(Seat seat);
    double getShowingAdjustment(Showing showing);
}
