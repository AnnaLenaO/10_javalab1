import java.util.function.Function;
import java.util.function.Predicate;

public class GeneralDiscount implements Discount {
    private final Predicate<Product> isApplicable;
    private final Function<Product, Double> calculateDiscount;
    private final Function<Product, String> description;

    public GeneralDiscount(Predicate<Product> isApplicable, Function<Product, Double> calculateDiscount,
                           Function<Product, String> description) {
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
        this.description = description;
    }

    public double apply(Product product) {
        if (isApplicable.test(product)) {
            return calculateDiscount.apply(product);
        }
        return 0;
    }

    public String getDescription(Product product) {
        if (isApplicable.test(product)) {
            return description.apply(product);
        }
        return "";
    }
}
