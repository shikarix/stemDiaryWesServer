package hello.repos;

import hello.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    ArrayList<Purchase> findAll();
    ArrayList<Purchase> findById(int id);
}
