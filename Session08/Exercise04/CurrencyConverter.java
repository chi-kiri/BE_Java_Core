package Exercise04;

public class CurrencyConverter {
    public static double exchangeRate = 25450.0;

    public static double toVND(double usd) {
        return usd * exchangeRate;
    }

    public static double toUSD(double vnd) {
        return vnd / exchangeRate;
    }

    public static void setExchangeRate(double rate) {
        exchangeRate = rate;
    }
}