package Exercise03;

public abstract class Product implements IDiscountable {
    private String id;
    private String name;
    private double originalPrice;

    public Product(String id, String name, double originalPrice) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}
