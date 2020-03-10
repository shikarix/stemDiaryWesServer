package hello.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    private Integer id;
    private Integer lessonId;
    private Integer pupilId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getPupilId() {
        return pupilId;
    }

    public void setPupilId(Integer pupilId) {
        this.pupilId = pupilId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", pupilId=" + pupilId +
                '}';
    }
}
