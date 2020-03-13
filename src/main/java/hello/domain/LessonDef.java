package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "lessons_names")
public class LessonDef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lessonId;
    private String lessonName;
    private GregorianCalendar firstTime;
    private String urlToLessonLogo;
    private int teacherId;

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public GregorianCalendar getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(GregorianCalendar firstTime) {
        this.firstTime = firstTime;
    }

    public String getUrlToLessonLogo() {
        return urlToLessonLogo;
    }

    public void setUrlToLessonLogo(String urlToLessonLogo) {
        this.urlToLessonLogo = urlToLessonLogo;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
