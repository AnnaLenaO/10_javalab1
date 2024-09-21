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
    public String getDescription(Product product) {
        String description = "";
//        return "10 % discount on fridays";
//        String description = "10 % discount on fridays";
//        return description + super.getDescription(product);

        if (isApplicable(product)) {
            description += "10 % discount on fridays. ";
        }
        description += super.getDescription(product);
        return description;
    }
}
