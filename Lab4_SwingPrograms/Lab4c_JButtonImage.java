// 4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ). 
package Lab4_SwingPrograms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Lab4c_JButtonImage extends JFrame {
    private JLabel messageLabel;
    private JButton digitalClockButton;
    private JButton hourglassButton;

    public Lab4c_JButtonImage() {
        setTitle("Button Image Example");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Label to display messages
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.NORTH);

        // Load and scale images
        ImageIcon digitalClockIcon = new ImageIcon("C:\\Users\\dell\\Desktop\\digital.jpg");
        ImageIcon hourGlassIcon = new ImageIcon("C:\\Users\\dell\\Desktop\\horglass.jpeg");

        Image scaledDigital = digitalClockIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        Image scaledHourglass = hourGlassIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        digitalClockButton = new JButton(new ImageIcon(scaledDigital));
        hourglassButton = new JButton(new ImageIcon(scaledHourglass));

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(digitalClockButton);
        buttonPanel.add(hourglassButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners
        digitalClockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Digital Clock is pressed");
            }
        });

        hourglassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Hour Glass is pressed");
            }
        });

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab4c_JButtonImage());
    }
}


