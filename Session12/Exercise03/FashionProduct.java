package Exercise03;

public class FashionProduct extends Product {
    public FashionProduct(String id, String name, double originalPrice) {
        super(id, name, originalPrice);
    }

    @Override
    public double getDiscountedPrice() {
        return getOriginalPrice() * 0.80;
    }
}
