public class Document {
    protected String content = "";

    public void addContent(String newContent) {
        content += newContent;
    }

    public String getContent() {
        return content;
    }
}

public class ReadOnlyDocument extends Document {
    @Override
    public void addContent(String newContent) {
        // Violates LSP by not supporting the addition of content
        throw new UnsupportedOperationException("Read-only document cannot be modified");
    }
}
