package Exercise06;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap = new HashMap<>();

    public void countWords(String text) {
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "")
                .toLowerCase()
                .trim();

        if (text.isEmpty()) {
            return;
        }

        String[] words = text.split("\\s+");

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
    }

    public void displayFrequency() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            result.append(String.format(
                    "| %-20s | %-31s |%n",
                    entry.getKey(),
                    entry.getValue() + " lần"
            ));
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |           BẢNG THỐNG KÊ TẦN SUẤT TỪ NGỮ             |
                +-------------------------------------------------------+
                | Từ khóa              | Số lần xuất hiện               |
                |----------------------+--------------------------------|
                %s+-------------------------------------------------------+
                """, result);
    }
}
