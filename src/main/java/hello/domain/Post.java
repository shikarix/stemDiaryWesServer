package hello.domain;

public class Post {
    private String srcToImage = "";
    private String text = "";
    private String date = "";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSrcToImage() {
        return srcToImage;
    }

    public void setSrcToImage(String srcToImage) {
        this.srcToImage = srcToImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
