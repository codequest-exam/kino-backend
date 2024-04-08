package dat3.kino.pricing;

import org.springframework.beans.factory.annotation.Autowired;

public class PriceManager {

    @Autowired
    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy strategyName) {
        this.pricingStrategy = pricingStrategy;
    }
}
