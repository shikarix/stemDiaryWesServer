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
