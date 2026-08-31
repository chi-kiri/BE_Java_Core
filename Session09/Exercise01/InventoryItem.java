package Exercise01;

public class InventoryItem {
    private String itemCode;
    private String itemName;
    private double price;
    private int quantity;

    public InventoryItem(String itemCode, String itemName, double price, int quantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        setQuantity(quantity);
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Lỗi: Số lượng tồn kho không được âm!");
        }
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void displayItem() {
        System.out.printf("""
                | Mặt hàng: %s | %s
                | Giá: %,.0f VNĐ | Tồn kho: %d sản phẩm
                """,
                this.itemCode,
                this.itemName,
                this.price,
                this.quantity
        );
    }
}
