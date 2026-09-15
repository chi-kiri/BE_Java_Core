package Exercise06;

public class Main {
    public static void main(String[] args) {
        String text = "Java is great and Java is powerful";

        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords(text);
        wordCounter.displayFrequency();
    }
}
