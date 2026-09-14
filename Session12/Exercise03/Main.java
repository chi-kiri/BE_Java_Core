package Exercise03;

public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct =
                new ElectronicProduct("E01", "Laptop Dell", 10000000);

        FashionProduct fashionProduct =
                new FashionProduct("F01", "Áo khoác Jean", 1000000);

        System.out.printf("""
                --- SO SÁNH GIÁ SẢN PHẨM SAU KHUYẾN MÃI ---

                +------------------------------------------------------------------+
                |                 BẢNG GIÁ SẢN PHẨM KHUYẾN MÃI                    |
                +------------------------------------------------------------------+
                | [%-15s] Niêm yết: %,.2f | Sau KM: %,.2f
                | [%-15s] Niêm yết: %,.2f | Sau KM: %,.2f
                +------------------------------------------------------------------+
                """,
                electronicProduct.getName(),
                electronicProduct.getOriginalPrice(),
                electronicProduct.getDiscountedPrice(),
                fashionProduct.getName(),
                fashionProduct.getOriginalPrice(),
                fashionProduct.getDiscountedPrice());
    }
}
