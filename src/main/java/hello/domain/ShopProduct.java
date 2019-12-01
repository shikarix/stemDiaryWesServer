package hello.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ShopProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    public void setCost(int cost) {
        this.cost = cost;
    }

    private String imgSrc;
    private String text;
    private String about;
    private Integer cost = 0;


    public Integer getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "ShopProduct{" +
                "id=" + id +
                ", imgSrc='" + imgSrc + '\'' +
                ", text='" + text + '\'' +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
