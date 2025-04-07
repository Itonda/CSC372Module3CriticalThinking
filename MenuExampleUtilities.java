import java.util.Random;
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
        String directoryPath = "C:\\Temp\\"; 
        File directory = new File(directoryPath);

        // Check if directory exists, create if not
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
        Random random = new Random();

        float hue = 0.25f + (0.17f * random.nextFloat()); // 90°–150° in HSB
        float saturation = 1.0f;
        float brightness = 1.0f;

        return Color.getHSBColor(hue, saturation, brightness);
    }
}