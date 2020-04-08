package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;


@Entity
@Table(name = "purs")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;
    private String login;
    private int customerId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Purchase() {

    }

    public Purchase(Integer id, String login) {
        this.productId = id;
        this.login = login;
    }
}
