public class ReadOnlyDocument implements Document {
    private final String content;

    public ReadOnlyDocument(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}