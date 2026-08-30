package Exercise06;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        System.out.println("--- THỬ NGHIỆM THÊM 6 SẢN PHẨM VÀO GIỎ HÀNG ---");
        System.out.println("Giỏ hàng mới: " + cart.getCartId());

        cart.addItem("Bàn phím cơ Dell");
        cart.addItem("Chuột Logitech");
        cart.addItem("Màn hình 24 inch");
        cart.addItem("Tai nghe Sony");
        cart.addItem("Lót chuột Gaming");

        System.out.println("Thêm 5 SP đầu tiên: Thành công");

        boolean result = cart.addItem("Webcam Logitech");

        if (!result) {
            System.out.println("Thêm SP thứ 6: Từ chối (Vượt MAX_ITEMS=" + Cart.MAX_ITEMS + ")");
        }

        cart.displayCart();
    }
}
