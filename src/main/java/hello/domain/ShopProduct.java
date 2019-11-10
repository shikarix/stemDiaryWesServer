package hello.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ShopProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String imgSrc = "";
    private String text = "";
    private int cost = 0;
    private String title = "";

    public Integer getId() {
        return id;
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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
