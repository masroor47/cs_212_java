import java.util.ArrayList;

public class WordLine {
    public String word;
    public int line;
    public ArrayList<Integer> lines;

    public WordLine(String word, int line) {
        if (line < 1) {
            throw new InvalidWordLineException("Wrong Line Number. You Good?");
        }
        this.word = word;
        this.line = line;

        this.lines = new ArrayList<Integer>();
        this.lines.add(line);
    }

    public void addLine(int line) {
        this.lines.add(line);
    }

    public String getLines() {
        String result = "" + lines.get(0);
        for (int i = 1; i < lines.size(); i++) {
            result += ", " + lines.get(i);
        }
        return result;
    }
    
}



