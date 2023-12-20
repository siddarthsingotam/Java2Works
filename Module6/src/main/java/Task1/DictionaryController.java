package Task1;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        //Added some initial words to the dictionary
        dictionary.addWord("apple", "A fruit");
        dictionary.addWord("java", "A high-level, class-based, object-oriented programming language.");
        dictionary.addWord("algorithm", "A step-by-step procedure formula for solving problems.");
    }

    public String searchWord(String word) {
        return dictionary.searchWord(word);
    }
}

