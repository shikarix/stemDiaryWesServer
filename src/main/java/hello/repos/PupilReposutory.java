package hello.repos;

import hello.domain.Pupil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PupilReposutory extends CrudRepository<Pupil, Integer> {
    List<Pupil> findByLoginAndPassword(String login, String password);
    List<Pupil> findByLogin(String login);
}
