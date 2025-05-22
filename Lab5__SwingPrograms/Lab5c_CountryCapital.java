// 5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada,  Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and  display the capital of the countries on console whenever the countries are selected on the list.  
package Lab5__SwingPrograms;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;
public class Lab5c_CountryCapital extends JFrame {
    private JList<String> countryList;
    private DefaultListModel<String> listModel;
    private HashMap<String, String> countryCapitalMap;
    public Lab5c_CountryCapital() {
        setTitle("Country Capital Viewer");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Initialize country-capital map
        countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("India", "New Delhi");
        countryCapitalMap.put("Vietnam", "Hanoi");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Denmark", "Copenhagen");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Great Britain", "London");
        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("Africa", "Varies by country");
        countryCapitalMap.put("Greenland", "Nuuk");
        countryCapitalMap.put("Singapore", "Singapore");
        // Create list model and populate countries
        listModel = new DefaultListModel<>();
        for (String country : countryCapitalMap.keySet()) {
            listModel.addElement(country);
        }
        // Create JList
        countryList = new JList<>(listModel);
        countryList.setVisibleRowCount(10);
        JScrollPane scrollPane = new JScrollPane(countryList);
        add(scrollPane);
        // Add ListSelectionListener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();
                    String capital = countryCapitalMap.get(selectedCountry);
                    System.out.println("Capital of " + selectedCountry + ": " + capital);
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Lab5c_CountryCapital();
    }
}
