package Task1;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), "Word not found in the dictionary.");
    }
}

