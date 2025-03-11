import javax.swing.*;
import java.awt.*;

class VowelGUI extends JFrame {
    
    public VowelGUI() {
        // Initializing a JFrame, setting up basic things
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Grid layout with 1 row, 2 columns
        setLayout(new GridLayout(1, 2));        
    }

    public void fillGUI(String paragraph, int[] vowels) {
        
        // Left Area
        Container paragraphContentPane = this.getContentPane();
        TextArea paragraphTextArea = new TextArea();
        paragraphContentPane.add(paragraphTextArea);

        // Right Area
        Container vowelsContentPane = this.getContentPane();
        TextArea vowelsTextArea = new TextArea();
        vowelsContentPane.add(vowelsTextArea);

        // Adding text to the left area
        paragraphTextArea.append(paragraph);
        
        // Adding vowel count to the right area
        String letters[] = {"a", "e", "i", "o", "u"};
        for (int i = 0; i < 5; i++) {
            vowelsTextArea.append("Number of '" + letters[i] + "': " + vowels[i] + "\n");
        }
        setVisible(true);
    }
}
