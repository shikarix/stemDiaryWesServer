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

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", pupilId=" + pupilId +
                '}';
    }
}
