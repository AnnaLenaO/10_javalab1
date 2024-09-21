abstract class BaseDiscount implements Discount {
    Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

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

        if (nextDiscount != null) {
            description += nextDiscount.getDescription(product);
        }
        return description;
    }
}
