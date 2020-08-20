package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

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
        Model model = Mockito.mock(Model.class);
        String redirect = controller.getIndexPage(model);
        Assert.assertEquals(redirect, "index");
        Mockito.verify(mockedCategoryRepository, Mockito.times(1)).findByDescription(Mockito.anyString());
        Mockito.verify(mockedUomRepository, Mockito.times(1)).getByUom(Mockito.anyString());


    }

}