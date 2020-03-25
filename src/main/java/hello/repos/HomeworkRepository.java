package hello.repos;

import hello.domain.Homework;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface HomeworkRepository extends CrudRepository<Homework, Integer> {
    ArrayList<Homework> findByDate(GregorianCalendar date);
    ArrayList<Homework> findByLessonId(int lessonId);
    ArrayList<Homework> findByLessonIdAndDate(int lessonId, GregorianCalendar date);
    ArrayList<Homework> findAll();
}
