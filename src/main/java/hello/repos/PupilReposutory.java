package hello.repos;

import hello.domain.Accounts;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface PupilReposutory extends CrudRepository<Accounts, Integer> {
    List<Accounts> findByLoginAndPassword(String login, String password);
    List<Accounts> findByLogin(String login);
    List<Accounts> findAllById(int id);
    ArrayList<Accounts> findAll();
    ArrayList<Accounts> findByName(String name);
}
