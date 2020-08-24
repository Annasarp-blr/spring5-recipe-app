package guru.springframework.controllers;

import guru.springframework.domain.Categories;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
@Slf4j
public class IndexController {

    private  CategoryRepository category;
    private  UnitOfMeasureRepository uom;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository category, UnitOfMeasureRepository uom, RecipeRepository recipeRepository) {
        this.category = category;
        this.uom = uom;
        this.recipeRepository = recipeRepository;
    }

    public CategoryRepository getCategory() {
        return category;
    }

    public UnitOfMeasureRepository getUom() {
        return uom;
    }
    @Autowired
    public void setCategory(CategoryRepository category) {
        System.out.println("-----> calling setCategory");
        this.category =  category;
    }
    @Autowired
    public void setUom(UnitOfMeasureRepository uom) {
        System.out.println("-----> calling setUom");
        this.uom = uom;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        Recipe r = recipeRepository.findByDescription("Guacamole").get();
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("asdasdad");
        ingredient.setRecipe(r);
        r.getIngredients().add(ingredient);
        recipeRepository.save(r);


        model.addAttribute("recipes", recipeRepository.findByDescription("American"));
        return "index";
    }
}