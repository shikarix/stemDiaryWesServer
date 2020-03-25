package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private GregorianCalendar date;
    private String homework;
    private int lessonId;

    public Homework(int id, GregorianCalendar date, String homework, int lessonId) {
        this.id = id;
        this.date = date;
        this.homework = homework;
        this.lessonId = lessonId;
    }

    public Homework() {
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", date=" + date +
                ", homework='" + homework + '\'' +
                ", lessonId=" + lessonId +
                '}';
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
}
