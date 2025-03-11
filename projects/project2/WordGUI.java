import javax.swing.*;
import java.awt.*;

/**
 * This custom WordGUI class extends JFrame and creates a frame that lets us display a paragraph and linked lists.
 */

public class WordGUI extends JFrame {

    public WordGUI() {

        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 3));

    }

    /**
     * This method fills the three columns created in the constructor.
     * <p>
     * The words in the Unsorted and the Sorted linked lists are displayed on each separate line
     * @param paragraph A String that contains the original paragraph. Will be displayed in the first column.
     * @param unsorted An Unsorted linked list which will be displayed in the middle
     * @param sorted A sorted linked list which will be displayed on the right
     */

    public void fillGUI(String paragraph, WordList unsorted, WordList sorted) {
        // Left area with the original paragraph
        Container paragraphContent = this.getContentPane();
        TextArea paragraphTextArea = new TextArea();
        paragraphContent.add(paragraphTextArea);
        
        paragraphTextArea.append(paragraph);

        //Container unsortedContent = this.getContentPane();
        TextArea unsortedTextArea = new TextArea();
        paragraphContent.add(unsortedTextArea);

        //Container sortedContent = this.getContentPane();
        TextArea sortedTextArea = new TextArea();
        paragraphContent.add(sortedTextArea);

        WordNode currentUnsorted = unsorted.head.next;
        WordNode currentSorted = sorted.head.next;
        for (int i = 0; i < unsorted.count; i++) {
            unsortedTextArea.append(currentUnsorted.val + "\n");
            sortedTextArea.append(currentSorted.val + "\n");
            currentUnsorted = currentUnsorted.next;
            currentSorted = currentSorted.next;
        }

        setVisible(true);
        

    }
}
