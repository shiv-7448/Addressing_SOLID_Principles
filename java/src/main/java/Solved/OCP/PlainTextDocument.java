public class PlainTextDocument implements PrintableDocument {
    private Document document;

    public PlainTextDocument(Document doc) {
        this.document = doc;
    }

    @Override
    public void print() {
        System.out.println(document.getContent());
    }
}