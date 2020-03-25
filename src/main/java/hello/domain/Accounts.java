package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;


@Entity
@Table(name = "usr")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean active = true;
    private boolean premium = false;

    private String login;
    private String password;

    private String name;
    private String surname;

    private int stemCoins;

    boolean isTeacher = false;
    boolean isAdmin = false;

    private String avatarUrl;

    //используется в некоторых страницах для единоразового отображения страницы
    private int currentMark = 0;

    public int getCurrentMark() {
        return currentMark;
    }

    public void setCurrentMark(int currentMark) {
        this.currentMark = currentMark;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStemCoins() {
        return stemCoins;
    }

    public void setStemCoins(int stemCoins) {
        this.stemCoins = stemCoins;
    }

    public boolean isThisTeacher() {
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

    public boolean isThisAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

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

    public boolean getAdmin(){
        return isAdmin;
    }

    public boolean getTeacher(){
        return isTeacher;
    }
}
