package Exercise04;

public class Main {
    public static void main(String[] args) {
        double usd = 100.0;

        double oldRate = CurrencyConverter.exchangeRate;
        double oldVnd = CurrencyConverter.toVND(usd);

        CurrencyConverter.setExchangeRate(25600.0);

        double newRate = CurrencyConverter.exchangeRate;
        double newVnd = CurrencyConverter.toVND(usd);
        double checkUsd = CurrencyConverter.toUSD(newVnd);

        System.out.printf("""
                --- CHUYỂN ĐỔI NGOẠI TỆ RIKKEI FINANCE ---
                Số tiền: %.0f USD
                Tỷ giá 1: %,.0f VNĐ/USD
                Tỷ giá 2: %,.0f VNĐ/USD

                +-------------------------------------------------------+
                |          BẢNG TÍNH CHUYỂN ĐỔI NGOẠI TỆ USD/VND       |
                +-------------------------------------------------------+
                | [Tỷ giá hiện tại] 1 USD = %,.2f VNĐ
                | -> %.2f USD = %,.2f VNĐ
                |-------------------------------------------------------|
                | [Cập nhật tỷ giá] 1 USD = %,.2f VNĐ
                | -> %.2f USD = %,.2f VNĐ
                |-------------------------------------------------------|
                | Kiểm tra đổi ngược: %,.2f VNĐ = %.2f USD
                +-------------------------------------------------------+
                """,
                usd,
                oldRate,
                newRate,
                oldRate,
                usd,
                oldVnd,
                newRate,
                usd,
                newVnd,
                newVnd,
                checkUsd
        );
    }
}
