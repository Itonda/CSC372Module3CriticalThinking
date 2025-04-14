
import java.awt.Color;
import java.io.PrintWriter;
import javax.swing.JOptionPane; 
import java.io.File; 

public class MenuExampleUtilities {

    // Method to handle and display export errors
    private static void handleExportError(String errorMessage, String errorTitle) {
        System.err.println("Error: " + errorMessage);
        JOptionPane.showMessageDialog(null, 
                                      errorMessage, 
                                      errorTitle, 
                                      JOptionPane.ERROR_MESSAGE);
    }
    
    // Method to export dateAndTimeLabel to a text file
    public static void exportToTextFile(String content, String filename) {
        String directoryPath = 
        System.getProperty("user.home") + 
        File.separator + "Temp" + 
        File.separator;

        // Check if directory exists, create if not
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                handleExportError("Could not create directory: " + directoryPath, "Directory Error");
                return; 
            }
        }

        String filePath = directoryPath + filename;

        // Check if the label content is empty or null or only whitespaces
        if (content == null || content.trim().isEmpty()) { 
            handleExportError("Cannot export: Date and Time label is empty.", "Export Error");
            return; 
        }

        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(content);
            System.out.println("Exported to " + filePath);
            // Show a success message
            JOptionPane.showMessageDialog(null, 
                                          "Successfully exported to " + filePath, 
                                          "Export Successful", 
                                          JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            handleExportError("Error writing to file: " + e.getMessage(), "File Error");
        }
    }

    // Method to get random green hue
    public static Color getRandomGreenHue() {

        float hue = 0.25f + (float)Math.random() * 0.1f; // Green hue range
        Color greenHue = Color.getHSBColor(hue, 0.8f, 0.8f);
        return greenHue;
    }
}