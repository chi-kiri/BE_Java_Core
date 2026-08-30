package Exercise06;

public class Cart {
    public static final int MAX_ITEMS = 5;
    private static int cartCount = 0;
    private String cartId;
    private String[] items = new String[MAX_ITEMS];
    private int currentCount = 0;

    public Cart() {
        cartId = "CART-" + (++cartCount);
    }

    public boolean addItem(String itemName) {
        if (currentCount < MAX_ITEMS) {
            items[currentCount++] = itemName;
            return true;
        } else {
            System.out.println("[Cảnh báo] GIỎ HÀNG ĐÃ ĐẦY! Không thể thêm sản phẩm.");
            return false;
        }
    }

    public void displayCart() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             CHI TIẾT GIỎ HÀNG RIKKEI STORE           |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| Mã Giỏ: " + cartId + " | Sức chứa tối đa: " + MAX_ITEMS + " sản phẩm");
        System.out.println("|-------------------------------------------------------|");

        for (int i = 0; i < currentCount; i++) {
            System.out.println("| " + (i + 1) + ". " + items[i]);
        }

        System.out.println("+-------------------------------------------------------+");
    }

    public String getCartId() {
        return cartId;
    }
}