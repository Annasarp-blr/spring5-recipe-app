package guru.springframework.repositories;

import guru.springframework.domain.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Long> {
    public Optional<Categories> findByDescription(String description);

}
