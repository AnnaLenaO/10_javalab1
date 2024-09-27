abstract class BaseDiscount implements Discount {
    private final Discount nextDiscount;

    protected BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    protected abstract String description(Product product);

    @Override
    public double apply(Product product) {
        double discount = 0;

        if (isApplicable(product)) {
            double currentDiscount = calculateDiscount(product);
            discount -= currentDiscount;
        }

        if (nextDiscount != null) {
            double nextDiscountValue = nextDiscount.apply(product);
            discount += nextDiscountValue;
        }
        return discount;
    }

    @Override
    public String getDescription(Product product) {
        String description = "";

        if (isApplicable(product)) {
            description = description(product);
        }

        if (nextDiscount != null) {
            String nextStringDescription = nextDiscount.getDescription(product);
            description += nextStringDescription;
        }
        return description;
    }
}
