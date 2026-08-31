package Exercise01;

public class Main {
    public static void main(String[] args) {
        InventoryItem item = new InventoryItem(
                "INV-01",
                "Chuột không dây",
                250000,
                20
        );

        System.out.println("--- KIỂM DUYỆT ĐÓNG GÓI INVENTORY ITEM ---");

        item.setQuantity(35);
        int quantityAfterValid = item.getQuantity();

        item.setQuantity(-5);
        int quantityAfterInvalid = item.getQuantity();

        System.out.printf("""
                +-------------------------------------------------------+
                |             NHẬT KÝ KIỂM DUYỆT KHO HÀNG              |
                +-------------------------------------------------------+
                | Mặt hàng: INV-01 | Chuột không dây
                |-------------------------------------------------------|
                | [Lần 1] Cập nhật SL = 35 => Thành công (Tồn kho: %d)
                | [Lần 2] LỖI: Số lượng tồn kho không được âm!
                | -> Số lượng tồn kho được giữ nguyên: %d sản phẩm
                +-------------------------------------------------------+
                """,
                quantityAfterValid,
                quantityAfterInvalid
        );
    }
}
