import javax.swing.*;
import java.awt.*;



class WordGUI extends JFrame {

    public WordGUI(String title) {
        setTitle(title);
        setSize(600, 400);
        createMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setVisible(true);
    }

    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();        
        JMenuItem item;

        FileMenuHandler fmh = new FileMenuHandler(this);

        // FILE 
        JMenu fileMenu = new JMenu("File");

        item = new JMenuItem("Open");
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator();
        
        item = new JMenuItem("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);

        menuBar.add(fileMenu);

        // LIST 
        JMenu listMenu = new JMenu("List");

        item = new JMenuItem("A");
        item.addActionListener(fmh);
        listMenu.add(item);

        item = new JMenuItem("E");
        item.addActionListener(fmh);
        listMenu.add(item);

        item = new JMenuItem("I");
        item.addActionListener(fmh);
        listMenu.add(item);

        item = new JMenuItem("O");
        item.addActionListener(fmh);
        listMenu.add(item);

        item = new JMenuItem("U");
        item.addActionListener(fmh);
        listMenu.add(item);

        menuBar.add(listMenu);
        setJMenuBar(menuBar);
    }
}


