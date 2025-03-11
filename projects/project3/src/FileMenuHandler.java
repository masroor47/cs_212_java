import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class FileMenuHandler implements ActionListener {

    JFrame jframe;

    // list of lists. each list stores words starting with its own vowel
    // First list is for A, second for E and so on
    ArrayList<ArrayList<WordLine>> vowels = new ArrayList<ArrayList<WordLine>>(5);

    // This maps the vowel character to the corresponding list index in the above list of lists
    HashMap<Character, Integer> vowelsIdx = new HashMap<Character, Integer>();
    

    public FileMenuHandler (JFrame jf) {
        this.jframe = jf;

        // Initializing the inner Lists
        vowels.add(new ArrayList<WordLine>());
        vowels.add(new ArrayList<WordLine>());
        vowels.add(new ArrayList<WordLine>());
        vowels.add(new ArrayList<WordLine>());
        vowels.add(new ArrayList<WordLine>());

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

        ArrayList<WordLine> list = vowels.get(vowelsIdx.get(v));

        Container myContentPane = jframe.getContentPane();
        TextArea myTextArea = new TextArea(); 
        myContentPane.add(myTextArea);
        
        // Go through each word in the list and append to the text area
        for (WordLine i : list) {
            myTextArea.append("line: "  + i.line + " - " + i.word + "\n");
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

        Container myContentPane = jframe.getContentPane();
        TextArea myTextArea = new TextArea();
        myContentPane.add(myTextArea);
     
        String line;
        line = inFile.readLine();
        int count = 1;

        while (line != null) {
            // Distribure the words in the line to the corresponding lists of words
            putInLists(line, count);

            // Adding the line to the left area to show the original full text
            myTextArea.append(count + "  " + line + "\n");
            line = inFile.readLine();
            count++;
        }

        // Sort the vowel lists after filling them
        for (int i = 0; i < 5; i++) {
            System.out.println("sorting " + i);
            Collections.sort(vowels.get(i), new WordLineComparator());
        }
        
        jframe.setVisible(true);  
    }

    private void putInLists(String line, int lineNum) {
        // regular expressions for splitting the words in a text file properly.
        String reg = "\\) \n| \\(|\\s+|, |[ ()\n]";
        String[] wordsInLine = line.split(reg, 0);

        for (String word : wordsInLine) {
            

            // If word starts with one of the vowels, then insert the word into that list
            if (this.vowelsIdx.containsKey(Character.toLowerCase(word.charAt(0)))) {
                // Create a WordLine object
                WordLine curr = new WordLine(word, lineNum);

                int vowelArray = vowelsIdx.get(Character.toLowerCase(word.charAt(0)));
                vowels.get(vowelArray).add(curr);
            }

        }

    }
    

}
