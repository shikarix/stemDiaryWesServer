package hello.repos;

import hello.domain.Accounts;
import hello.domain.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    ArrayList<Lesson> findAll();
    ArrayList<Lesson> findByLessonId(Integer id);
    ArrayList<Lesson> findByPupilId(Integer id);
    ArrayList<Lesson> findByLessonIdAndPupilId(Integer lessonId, Integer pupilId);
}
