import java.time.DayOfWeek;
import java.time.LocalDate;

class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        LocalDate today = LocalDate.now();
        return today.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.1;
    }

    @Override
    public String description(Product product) {
        return "Friday Discount 10 %";
    }
}
