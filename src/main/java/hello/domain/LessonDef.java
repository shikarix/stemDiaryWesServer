package hello.domain;

import javax.persistence.*;
import java.util.Calendar;
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

    @Override
    public String toString() {
        return "LessonDef{" +
                "lessonId=" + lessonId +
                ", lessonName='" + lessonName + '\'' +
                ", firstTime=" + firstTime +
                ", urlToLessonLogo='" + urlToLessonLogo + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public String getFirstTimeString(){
        return (firstTime.get(Calendar.DAY_OF_MONTH) > 9 ? firstTime.get(Calendar.DAY_OF_MONTH) : "0" + firstTime.get(Calendar.DAY_OF_MONTH)) + "." +
                (firstTime.get(Calendar.MONTH) > 9 ? (firstTime.get(Calendar.MONTH) + 1) : "0" + (firstTime.get(Calendar.MONTH) + 1))+ "." +
                (firstTime.get(Calendar.YEAR)) + "  " +
                (firstTime.get(Calendar.HOUR_OF_DAY) > 9 ? firstTime.get(Calendar.HOUR_OF_DAY) : "0" + firstTime.get(Calendar.HOUR_OF_DAY)) + ":" +
                (firstTime.get(Calendar.MINUTE) > 9 ? firstTime.get(Calendar.MINUTE) : "0" + firstTime.get(Calendar.MINUTE));
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
