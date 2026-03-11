public class RawData {

    private String type;
    private String source;
    private String content;

    public RawData(String type, String source, String content) {
        this.type = type;
        this.source = source;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
