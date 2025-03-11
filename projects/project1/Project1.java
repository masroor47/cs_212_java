

public class Project1 {


    public static void main(String[] args) {

        // array stores vowels counts for
        // a, e, i, o, u at corresponding indecies
        int vowels[] = countVowels("input.txt");
        // String stores the original paragraph in string format
        String paragraph = readParagraph("input.txt");

        // Initializing custom made class
        VowelGUI vGUI = new VowelGUI();
        // Using custom-defined method to fill up the columns
        vGUI.fillGUI(paragraph, vowels);
    }


    // Reads the file and appends each line to a string and then returns it
    public static String readParagraph(String fileName) {
        TextFileInput tfi = new TextFileInput("input.txt");
        String paragraph = "";
        String line = tfi.readLine();
        while (line != null) {
            paragraph += line + "\n";
            line = tfi.readLine();
        }
        return paragraph;
    }

    // Reads the file and increments the integer corresponding to a vowel
    public static int[] countVowels(String fileName) {
        TextFileInput tfi = new TextFileInput("input.txt");
        
        int vowels[] = {0, 0, 0, 0, 0};
        String line = tfi.readLine();
        while (line != null) {
            // Goes through each character in the line
            // Counts the corresponding vowels
            for (int i = 0; i < line.length(); i++) {
                if (Character.toLowerCase(line.charAt(i)) == 'a') {
                    vowels[0] += 1;
                } else if (Character.toLowerCase(line.charAt(i)) == 'e') {
                    vowels[1] += 1;
                } else if (Character.toLowerCase(line.charAt(i)) == 'i') {
                    vowels[2] += 1;
                } else if (Character.toLowerCase(line.charAt(i)) == 'o') {
                    vowels[3] += 1;
                } else if (Character.toLowerCase(line.charAt(i)) == 'u') {
                    vowels[4] += 1;
                }
            }

            // read new line
            line = tfi.readLine();
        }
        return vowels;
    }
}