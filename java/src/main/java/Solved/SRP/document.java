public class Document {
    private String content;

    public void addContent(String newContent) {
        content += newContent;
    }

    public String getContent() {
        return content;
    }
}