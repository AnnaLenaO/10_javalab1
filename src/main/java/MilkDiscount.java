import java.util.Objects;

class MilkDiscount extends BaseDiscount {
    protected MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return Objects.equals(product.name(), "milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.05;
    }

    @Override
    protected String description(Product product) {
        return "Milk Discount 5 %. ";
    }
}
