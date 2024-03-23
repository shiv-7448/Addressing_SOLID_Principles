public class DocumentPersistence {
    public void saveToFile(Document doc, String filename) {
        String content = doc.getContent(); // Get the content from the Document object
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}