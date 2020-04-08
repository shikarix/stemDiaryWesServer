package hello.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private GregorianCalendar date;
    private int pupilId;
    private int homeworkDoingMark;
    private int behaviourMark;
    private int lessonDoingMark;
    private int lessonId;

    private int totalStemCoins;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", date=" + date +
                ", pupilId=" + pupilId +
                ", homeworkDoingMark=" + homeworkDoingMark +
                ", behaviourMark=" + behaviourMark +
                ", lessonDoingMark=" + lessonDoingMark +
                ", totalStemCoins=" + totalStemCoins +
                '}';
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

    public int getPupilId() {
        return pupilId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }

    public int getHomeworkDoingMark() {
        return homeworkDoingMark;
    }

    public void setHomeworkDoingMark(int homeworkDoingMark) {
        this.homeworkDoingMark = homeworkDoingMark;
    }

    public int getBehaviourMark() {
        return behaviourMark;
    }

    public void setBehaviourMark(int behaviourMark) {
        this.behaviourMark = behaviourMark;
    }

    public int getLessonDoingMark() {
        return lessonDoingMark;
    }

    public void setLessonDoingMark(int lessonDoingMark) {
        this.lessonDoingMark = lessonDoingMark;
    }

    public int getTotalStemCoins() {
        return totalStemCoins;
    }

    public void setTotalStemCoins(int totalStemCoins) {
        this.totalStemCoins = totalStemCoins;
    }
}
