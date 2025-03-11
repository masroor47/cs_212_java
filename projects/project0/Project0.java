import javax.swing.*;

public class Project0 {
    public static void main(String[] args) {


        String inputSentance;
        int capitalECount = 0;
        int lowerECount = 0;
        // Endless loop to keep taking input.
        // Stops when user inputs 'stop'
        while(true) {
            inputSentance = JOptionPane.showInputDialog(null, "Please enter a sentance.");

            if (inputSentance.equalsIgnoreCase("stop")) {
                System.exit(0);
            }

            // Iterating through the string and checking if character is E or e
            for (int i = 0; i < inputSentance.length(); i++) {

                if (inputSentance.charAt(i) == 'E') {
                    capitalECount++;
                } else if (inputSentance.charAt(i) == 'e') {
                    lowerECount++;
                }

            }
            // Building the final message.
            String result = "Number of lower case e's: " + lowerECount + "\nNumber of upper case e's: " + capitalECount;
            // Output using JOptionPane
            JOptionPane.showMessageDialog(null, result);
        }
    }
}
