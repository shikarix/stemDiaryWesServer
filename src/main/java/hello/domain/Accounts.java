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

    //используется в некоторых страницах для единоразового отображения
    private int currentMark = 0;
    private boolean isHere = false;

    public boolean isHere() {
        return isHere;
    }

    public boolean getHere(){
        return isHere;
    }

    public void setHere(boolean here) {
        isHere = here;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

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

    public Accounts(Integer id, String login, String password, String name, String surname, boolean isTeacher, boolean isAdmin, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isTeacher = isTeacher;
        this.isAdmin = isAdmin;
        this.avatarUrl = avatarUrl;
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

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", active=" + active +
                ", premium=" + premium +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", stemCoins=" + stemCoins +
                ", isTeacher=" + isTeacher +
                ", isAdmin=" + isAdmin +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", currentMark=" + currentMark +
                '}';
    }
}
