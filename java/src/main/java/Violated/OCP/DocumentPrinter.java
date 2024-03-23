public class DocumentPrinter {
    public void print(Document doc) {
        // Directly print the document, no flexibility for different formats
        System.out.println(doc.getContent());
    }
}
