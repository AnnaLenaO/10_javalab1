import java.util.Objects;

class MilkDiscount extends BaseDiscount {
    public MilkDiscount(Discount nextDiscount) {
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
    public String description(Product product) {
        return "Milk Discount 5 %";
    }
}
