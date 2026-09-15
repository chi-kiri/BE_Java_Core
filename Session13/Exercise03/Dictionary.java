package Exercise03;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dict = new HashMap<>();

    public void addWord(String eng, String vie) {
        dict.put(eng, vie);
    }

    public String lookup(String eng) {
        if (dict.containsKey(eng)) {
            return dict.get(eng);
        }
        return "Không tìm thấy";
    }

    public boolean deleteWord(String eng) {
        if (dict.containsKey(eng)) {
            dict.remove(eng);
            return true;
        }
        return false;
    }

    public void displayDictionary() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : dict.entrySet()) {
            result.append(String.format(
                    "| - %-15s : %s%n",
                    entry.getKey(),
                    entry.getValue()
            ));
        }

        System.out.printf("""
                | -> DANH SÁCH TỪ ĐIỂN HIỆN TẠI:
                |-------------------------------------------------------|
                %s+-------------------------------------------------------+
                """, result);
    }
}
