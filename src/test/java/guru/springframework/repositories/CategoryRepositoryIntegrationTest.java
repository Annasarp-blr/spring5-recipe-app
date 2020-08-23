package guru.springframework.repositories;

import guru.springframework.domain.Categories;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CategoryRepositoryIntegrationTest extends TestCase {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testFindByDescription() {
       Categories category = categoryRepository.findByDescription("American").get();
       Assert.assertEquals("American", category.getDescription());
    }

}