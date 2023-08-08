
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = scanner.nextLine().trim();

        Map<String, Integer> wordOccurrences = countWords(input);

        System.out.println("Number of unique words: " + wordOccurrences.size());
        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordOccurrences = new HashMap<>();

        if (input.isEmpty()) {
            return wordOccurrences;
        }

        String[] words = input.split("\\s+");
        for (String word : words) {
            // Remove punctuation from the word (optional, depending on your use case)
            word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // Update the count in the map
            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
        }

        return wordOccurrences;
    }
}
