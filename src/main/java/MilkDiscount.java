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
    public String getDescription(Product product) {
        String description = "";
//        return "5 % discount for milk";
//        String description = "5 % discount for milk";
//        return description + super.getDescription(product);

        if (isApplicable(product)) {
            description += "5 % discount for milk. ";
        }
        description += super.getDescription(product);
        return description;
    }
}
