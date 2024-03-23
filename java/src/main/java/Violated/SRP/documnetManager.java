import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentManager {
    private String content = ""; // Initialize content to avoid null concatenation

    public void addContent(String newContent) {
        content += newContent;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
