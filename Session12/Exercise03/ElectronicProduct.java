package Exercise03;

public class ElectronicProduct extends Product {
    public ElectronicProduct(String id, String name, double originalPrice) {
        super(id, name, originalPrice);
    }

    @Override
    public double getDiscountedPrice() {
        return getOriginalPrice() * 0.95;
    }
}