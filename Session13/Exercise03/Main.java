package Exercise03;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("computer", "máy tính");
        dictionary.addWord("algorithm", "thuật toán");
        dictionary.addWord("database", "cơ sở dữ liệu");
        dictionary.addWord("network", "mạng máy tính");

        String word = "algorithm";
        String meaning = dictionary.lookup(word);

        dictionary.deleteWord("database");

        System.out.printf("""
                --- TỪ ĐIỂN ANH - VIỆT RIKKEI ---

                +-------------------------------------------------------+
                |             TỪ ĐIỂN ANH - VIỆT RIKKEI                |
                +-------------------------------------------------------+
                | Tra cứu '%s': => %s
                |-------------------------------------------------------|
                """,
                word,
                meaning.toUpperCase());

        dictionary.displayDictionary();
    }
}
