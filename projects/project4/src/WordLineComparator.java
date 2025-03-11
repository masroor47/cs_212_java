import java.util.Comparator;

class WordLineComparator implements Comparator <WordLine> {
    
    public int compare(WordLine a, WordLine b) {
        return a.word.compareTo(b.word);
    }
}
