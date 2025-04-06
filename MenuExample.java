import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// GUI class
public class MenuExample extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 15);
    public static JLabel dateAndTimeLabel = new JLabel();
    
    // Constructor
    public void initialize() {
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        // Create a menu
        JMenu functionsMenu = new JMenu("Functions");
        // Create menu items
        JMenuItem menuItem1 = new JMenuItem("Display Date and Time");
        JMenuItem menuItem2 = new JMenuItem("Export to Text File");
        JMenuItem menuItem3 = new JMenuItem("Change Background Color:   ");

        // Set the layout for menuItem3 to BorderLayout to display the color square
        menuItem3.setLayout(new BorderLayout());
        
        JMenuItem menuItem4 = new JMenuItem("Exit");

        // Generate the initial random green hue
        Color initialColor = MenuExampleUtilities.getRandomGreenHue();

        // Set the frame to the initial random green hue
        getContentPane().setBackground(initialColor);

        // Panel to hold the date and time label
        JPanel dateAndTimePanel = new JPanel();
        dateAndTimePanel.setLayout(new GridLayout(1, 1)); 
        dateAndTimePanel.setOpaque(false); // Make the panel transparent; helps to display the background color of frame
        dateAndTimeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align the label to the center
        dateAndTimePanel.add(dateAndTimeLabel); 
        dateAndTimeLabel.setFont(mainFont); 

        // Panel to hold the color square
        JPanel colorSquare = new JPanel();
        colorSquare.setPreferredSize(new Dimension(20, 20)); 
        colorSquare.setBackground(initialColor); // Set initial color to the generated random green hue
        colorSquare.setOpaque(true); // Make sure the panel is opaque to show the background color
        menuItem3.add(colorSquare, BorderLayout.EAST); // Add the color square to right of the menu item text

        // Listeners for menu items
        menuItem1.addActionListener(e -> {
            // Get the current date and time and format it
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
        
            // Update the label
            dateAndTimeLabel.setText("Current Date and Time: " + formattedDateTime);
        });

        menuItem2.addActionListener(e -> {
            // Export the date and time to a text file
            String filename = "log.txt";
            MenuExampleUtilities.exportToTextFile(filename);
        });

        menuItem3.addActionListener(e -> {
            // Generate a random green hue
            Color randomGreenHue = MenuExampleUtilities.getRandomGreenHue();
            // Set the frame's background color
            getContentPane().setBackground(randomGreenHue);
            
        });
           
        menuItem4.addActionListener(e -> {
            // Exit the application
            System.exit(0);
        });
        
        // Set up the frame
        setTitle("Menu Example");
        setSize(300, 200);
        setMinimumSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // Add menu items to the functions menu
        functionsMenu.add(menuItem1);
        functionsMenu.add(menuItem2);
        functionsMenu.add(menuItem3);
        functionsMenu.add(menuItem4);
        // Add functions menu to the menu bar
        menuBar.add(functionsMenu);
        // Add the menu bar to the frame
        setJMenuBar(menuBar);
        // Add the date and time panel to the frame
        add(dateAndTimePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuExample frame = new MenuExample();
            frame.initialize();
        });
    }
}