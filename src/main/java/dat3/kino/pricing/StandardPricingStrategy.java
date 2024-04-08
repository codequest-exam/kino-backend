package dat3.kino.pricing;

import dat3.kino.seat.Seat;
import dat3.kino.showing.Showing;

public class StandardPricingStrategy implements PricingStrategy {

    public double getBasicSeatPrice(Seat seat) {
        return seat.getPriceClass().getPrice();
    }

    public double

    @Override
    public double getShowingAdjustment(Showing showing) {
        return 0;
    }
}
