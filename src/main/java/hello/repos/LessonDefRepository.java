package hello.repos;

import hello.domain.LessonDef;
import org.springframework.data.repository.CrudRepository;

public interface LessonDefRepository extends CrudRepository<LessonDef, Integer> {

}
