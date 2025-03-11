

public class Project2 {

    public static void main(String[] args) {
        
        String paragraph = readParagraph("input.txt");

        //System.out.println(paragraph);
        UnsortedWordList unsortedList = new UnsortedWordList();
        SortedWordList sortedList = new SortedWordList();

        // regular expression delimeter
        String reg = "\\) \n| \\(|\\s+|, |[ ()\n]";

        String[] paragraphArr = paragraph.split(reg, 0);
        for (String s : paragraphArr) {
            unsortedList.append(s);
            sortedList.add(s);
        } 
        
        // System.out.println("Unsorted List: ");
        // System.out.println(unsortedList);
        // System.out.println("Sorted List: ");
        // System.out.println(sortedList);

        WordGUI myGUI = new WordGUI();

        myGUI.fillGUI(paragraph, unsortedList, sortedList);
    }

    public static String readParagraph(String filename) {
        TextFileInput tfi = new TextFileInput(filename);
        
        String result = "";
        String line = tfi.readLine();
        while (line != null) {
            result += line + "\n";
            line = tfi.readLine();
        }
        return result;



    }








    public static void testLists() {
        // UnsortedWordList unsortedList = new UnsortedWordList();

        // unsortedList.append("Hey");
        // unsortedList.append("Man");
        // unsortedList.append("How are you");

        // System.out.println(unsortedList);

        // SortedWordList sortedList = new SortedWordList();
        // sortedList.add("gg");
        // sortedList.add("tt");
        // sortedList.add("pp");
        // sortedList.add("pp");
        // sortedList.add("zz");
        // sortedList.add("aa");
        // sortedList.add("cc");
        // sortedList.add("ww");
        // sortedList.add("jj");
        // sortedList.add("xx");
        // sortedList.add("jjj");
        // sortedList.add("ca");

        // System.out.println(sortedList);
    } // Testing the Linked Lists
}
