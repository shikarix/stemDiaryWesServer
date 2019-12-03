package hello.repos;

import hello.domain.ShopProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ShopProduct, Integer> {
    List<ShopProduct> findByCost(Integer cost);
    List<ShopProduct> findByTitleAndCost(String title, Integer cost);
    List<ShopProduct> findByTitle(String title);

}
