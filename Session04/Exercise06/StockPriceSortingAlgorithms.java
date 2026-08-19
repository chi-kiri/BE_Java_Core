import java.util.Arrays;

public class StockPriceSortingAlgorithms {

    public static void main(String[] args) {
        double[] prices = {
                85.5, 92.0, 78.5, 88.0,
                95.5, 81.0, 75.0, 90.0
        };

        double[] arraySelection = new double[prices.length];
        double[] arrayInsertion = new double[prices.length];

        System.arraycopy(prices, 0, arraySelection, 0, prices.length);
        System.arraycopy(prices, 0, arrayInsertion, 0, prices.length);

        int selectionSwaps = 0;

        for (int i = 0; i < arraySelection.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arraySelection.length; j++) {
                if (arraySelection[j] < arraySelection[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                double temp = arraySelection[i];
                arraySelection[i] = arraySelection[minIndex];
                arraySelection[minIndex] = temp;

                selectionSwaps++;
            }
        }

        int insertionShifts = 0;

        for (int i = 1; i < arrayInsertion.length; i++) {
            double current = arrayInsertion[i];
            int j = i - 1;

            while (j >= 0 && arrayInsertion[j] > current) {
                arrayInsertion[j + 1] = arrayInsertion[j];
                insertionShifts++;
                j--;
            }

            arrayInsertion[j + 1] = current;
        }

        System.out.printf("""
                --- HỆ THỐNG PHÂN TÍCH GIÁ CỔ PHIẾU RIKKEI SECURITY ---

                Lịch sử 8 phiên gốc: %s

                +------------------------------------------------------------+
                |           BẢNG SO SÁNH HIỆU NĂNG THUẬT TOÁN              |
                +------------------------------------------------------------+
                | Mảng sau sắp xếp: %s
                |------------------------------------------------------------|
                | Selection Sort: Hoàn thành với %d lần hoán vị
                | Insertion Sort: Hoàn thành với %d lần dịch chuyển
                | Đánh giá tối ưu: Selection Sort ít thao tác ghi hơn
                +------------------------------------------------------------+
                """,
                Arrays.toString(prices),
                Arrays.toString(arraySelection),
                selectionSwaps,
                insertionShifts
        );
    }
}