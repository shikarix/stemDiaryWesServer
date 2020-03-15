package hello.repos;

import hello.domain.LessonDef;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LessonDefRepository extends CrudRepository<LessonDef, Integer> {
    ArrayList<LessonDef> findByLessonId(Integer id);
    ArrayList<LessonDef> findByTeacherId(Integer id);
    ArrayList<LessonDef> findByLessonName(String lessonName);
}
