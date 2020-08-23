package guru.springframework.controllers;

import guru.springframework.domain.Categories;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;

public class IndexControllerTest extends TestCase {

    CategoryRepository mockedCategoryRepository;
    UnitOfMeasureRepository mockedUomRepository;
    IndexController controller;

    @Before
    public  void setUp() {

        mockedCategoryRepository = Mockito.mock(CategoryRepository.class);
        mockedUomRepository = Mockito.mock(UnitOfMeasureRepository.class);
        controller = new IndexController(mockedCategoryRepository, mockedUomRepository);

    }

    @Test
    public void testIndexPage() {
        Model mockedModel = Mockito.mock(Model.class);
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("efgh");

        Categories cat = new Categories();
        cat.setId(1L);
        cat.setDescription("American");
        Optional<Categories> optCategoy = Optional.of(cat);

        Mockito.when(mockedCategoryRepository.findByDescription(eq("American"))).thenReturn(optCategoy);
        ArgumentCaptor<Optional> categoriesArgumentCaptor = ArgumentCaptor.forClass(Optional.class);

        String redirect = controller.getIndexPage(mockedModel);
        Assert.assertEquals(redirect, "index");
        Mockito.verify(mockedCategoryRepository, Mockito.times(1)).
                findByDescription(eq("American"));
        Mockito.verify(mockedModel, Mockito.times(1)).addAttribute(eq("recipes"),
                categoriesArgumentCaptor.capture());

        Categories categories = (Categories)categoriesArgumentCaptor.getValue().get();

        Assert.assertEquals(categories.getId(), cat.getId());


    }

}