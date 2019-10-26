package hello.repos;

import hello.domain.Pupil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PupilReposutory extends CrudRepository<Pupil, Integer> {
    List<Pupil> findByLogin(String login);
}
