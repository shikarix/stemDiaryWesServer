package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "usr")
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;
    private String password;
    private String course[];
    private int stemCoins = 0;
    private String name;
    private String surname;
    private boolean active;
    private String avatarUrl;
    private boolean isTeacher = false;
    private boolean isAdmin = false;
    private GregorianCalendar firstDate = new GregorianCalendar();
    private String stringLesson = "";

    public String getStringLesson() {
        return stringLesson;
    }

    public void setStringLesson(String stringLesson) {
        this.stringLesson = stringLesson;
    }

    public GregorianCalendar getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(GregorianCalendar firstDate) {
        this.firstDate = firstDate;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }

    private boolean isModerator = false;

    public boolean isTeacher() {
        return isTeacher;
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

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStemCoins() {
        return stemCoins;
    }

    public void setStemCoins(int stemCoins) {
        this.stemCoins = stemCoins;
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

    public Pupil() {

    }

    public Pupil(String login, String password) {
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

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }
}
