
public class WordLine {
    public String word;
    public int line;

    public WordLine(String word, int line) {
        if (line < 1) {
            throw new InvalidWordLineException("Wrong Line Number. You Good?");
        }
        this.word = word;
        this.line = line;
    }
    
}



