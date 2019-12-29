package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;
    private String password;

    private String name;
    private String surname;

    private boolean isTeacher = false;
    private boolean isAdmin = false;

    private String avatarUrl;

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "coins")
    private int coins;

    @CollectionTable(name = "lessons", joinColumns = @JoinColumn(name = "id"))
    private Lesson[] lessons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Accounts() {

    }

    public Accounts(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }
}
