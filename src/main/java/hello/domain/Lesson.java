package hello.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @CollectionTable(name = "typeoflesson", joinColumns = @JoinColumn(name = "id"))
    private int typeOfLessonId;

    @CollectionTable(name = "groups", joinColumns = @JoinColumn(name = "id"))
    private int groupId;

    private GregorianCalendar calendar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeOfLessonId() {
        return typeOfLessonId;
    }

    public void setTypeOfLessonId(int typeOfLessonId) {
        this.typeOfLessonId = typeOfLessonId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }
}
