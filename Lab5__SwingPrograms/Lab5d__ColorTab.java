// 5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and  display the concerned color whenever the specific tab is selected in the Pan 
package Lab5__SwingPrograms;
import javax.swing.*;
import java.awt.*;

public class Lab5d__ColorTab extends JFrame {
    public Lab5d__ColorTab() {
        setTitle("Tabbed Color Pane");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        // Create panels for each color
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        tabbedPane.addTab("Cyan", cyanPanel);
        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);
        tabbedPane.addTab("Magenta", magentaPanel);
        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        tabbedPane.addTab("Yellow", yellowPanel);
        // Add tabbed pane to frame
        add(tabbedPane);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Lab5d__ColorTab();
    }
}

    

