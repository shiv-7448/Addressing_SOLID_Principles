import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFDocument implements PrintableDocument {
    private Document document;

    public PDFDocument(Document doc) {
        this.document = doc;
    }

    @Override
    public void print() {
        try (PDDocument pdfDocument = new PDDocument()) {
            PDPage page = new PDPage();
            pdfDocument.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(document.getContent());
                contentStream.endText();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Save the document
            String filename = "document.pdf";
            pdfDocument.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
