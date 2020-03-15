package hello.repos;

import hello.domain.Homework;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public interface HomeworkRepository extends CrudRepository<Homework, Integer> {
    ArrayList<Homework> findByHref(String href);
    ArrayList<Homework> findByDate(GregorianCalendar date);
}
