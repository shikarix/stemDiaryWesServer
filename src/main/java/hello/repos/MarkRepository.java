package hello.repos;

import hello.domain.Mark;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface MarkRepository extends CrudRepository<Mark, Integer> {
    ArrayList<Mark> findAll();
    ArrayList<Mark> findByDateAndPupilId(GregorianCalendar date, int pupilId);
}
