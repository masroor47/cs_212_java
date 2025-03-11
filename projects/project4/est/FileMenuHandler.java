import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class FileMenuHandler implements ActionListener {

    JFrame jframe;
    private TextArea leftTextArea;
    private TextArea rightTextArea;

    // List of HashMaps. Each HashMap stores the word as a key and a WordLine object as a value
    // First list is for A, second for E and so on...
    ArrayList<HashMap<String, WordLine>> vowelsMaps = new ArrayList<HashMap<String, WordLine>>();

    // This map maps the vowel character to the corresponding list index in the above list of lists
    HashMap<Character, Integer> vowelsIdx = new HashMap<Character, Integer>();
    

    public FileMenuHandler (JFrame jf) {
        this.jframe = jf;

        // Left and right areas
        Container myContentPane = jframe.getContentPane();
        leftTextArea = new TextArea(); 
        myContentPane.add(leftTextArea);

        Container rightContentPane = jframe.getContentPane();
        rightTextArea = new TextArea(); 
        rightContentPane.add(rightTextArea);
        

        // Initializing the inner HashMaps
        for (int i = 0; i < 5; i++) {
            vowelsMaps.add(new HashMap<String, WordLine>());
        }

        // Filling up the map
        vowelsIdx.put('a', 0);
        vowelsIdx.put('e', 1);
        vowelsIdx.put('i', 2);
        vowelsIdx.put('o', 3);
        vowelsIdx.put('u', 4);
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        
        } else { // If its neither of the above, it must be one of the List menu items
            getWords(menuName);
        }
    }

    private void getWords(String vowel) {
        char v = Character.toLowerCase(vowel.charAt(0));

        HashMap<String, WordLine> currMap = vowelsMaps.get(vowelsIdx.get(v));

        rightTextArea.setText("");
        
        ArrayList<WordLine> tempList = new ArrayList<WordLine>();
        currMap.forEach((key, value) -> tempList.add(value) );

        // Sorting the WordLines
        Collections.sort(tempList, new WordLineComparator());

        // Go through each word in the list and append to the text area
        for (WordLine i : tempList) {
            rightTextArea.append(i.word + ": " + i.getLines() + "\n");
        }
        

        jframe.setVisible(true);
    }

    private void openFile() {
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            readSource(chooser.getSelectedFile());
        } else {
            JOptionPane.showMessageDialog(null, "'Open File' dialog canceled. They got to him too.");
        }
    }

    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getName();
        TextFileInput inFile = new TextFileInput(chosenFileName);

        leftTextArea.setText("");
     
        String line;
        line = inFile.readLine();
        int count = 1;

        while (line != null) {
            // Distribure the words in the line to the corresponding HashMap
            putInMaps(line, count);

            // Adding the line to the left area to show the original full text
            leftTextArea.append(count + "  " + line + "\n");
            line = inFile.readLine();
            System.out.println("newly read line: " + line);
            count++;
        }
        
        jframe.setVisible(true);  
    }

    private void putInMaps(String line, int lineNum) {
        // regular expressions for splitting the words in a text file properly.
        String reg = "\\) \n| \\(|\\s+|, |[ ()\n]";
        String[] wordsInLine = line.split(reg, 0);

        for (String word : wordsInLine) {

            // If word starts with one of the vowels, then insert the word into that list
            if (this.vowelsIdx.containsKey(Character.toLowerCase(word.charAt(0)))) {

                int vowelArray = vowelsIdx.get(Character.toLowerCase(word.charAt(0)));

                // Check if a WordLine with this word already exists
                HashMap<String, WordLine> currMap = vowelsMaps.get(vowelArray);
                if (currMap.containsKey(word)) { // If so, simply append a line number to the WordLine's ArrayList
                    currMap.get(word).addLine(lineNum);
                } else { // If not, create a new Wordline
                    currMap.put(word, new WordLine(word, lineNum));
                }
            }
        }
    }
}
