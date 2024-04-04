import java.util.HashMap;

public class third {

    public static HashMap<String, Integer> countWords(String str) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        StringBuilder word = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (word.length() > 0) {
                    String currentWord = word.toString().toLowerCase();
                    if (wordCountMap.containsKey(currentWord)) {
                        wordCountMap.put(currentWord, wordCountMap.get(currentWord) + 1);
                    } else {
                        wordCountMap.put(currentWord, 1);
                    }
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            String currentWord = word.toString().toLowerCase();
            if (wordCountMap.containsKey(currentWord)) {
                wordCountMap.put(currentWord, wordCountMap.get(currentWord) + 1);
            } else {
                wordCountMap.put(currentWord, 1);
            }
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        String inputString = "This is a sample string to count the number of words in a string";
        HashMap<String, Integer> wordCountMap = countWords(inputString);

        System.out.println("Word count in the string:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
