package guru.springframework;

import guru.springframework.domain.Categories;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.domain.enums.Difficulty;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {
    private final IngredientRepository ingredients;
    private final RecipeRepository recipes;
    private final UnitOfMeasureRepository unitOfMeasure;
    private  final CategoryRepository categories;
    private final RestTemplate restTemplate;

    public Bootstrap(IngredientRepository ingredients, RecipeRepository recipes, UnitOfMeasureRepository unitOfMeasure, CategoryRepository categories, RestTemplate restTemplate) {
        this.ingredients = ingredients;
        this.recipes = recipes;
        this.unitOfMeasure = unitOfMeasure;
        this.categories = categories;

        this.restTemplate = restTemplate;
    }



    @Override
   @Transactional
    public void run(String... args) throws Exception {


        UnitOfMeasure teaSpoonMeasure = unitOfMeasure.getByUom("Teaspoon").get();
        UnitOfMeasure tableSpoonMeasure = unitOfMeasure.getByUom("Tablespoon").get();
        UnitOfMeasure cupMeasure = unitOfMeasure.getByUom("Cup").get();
        Categories category = categories.findByDescription("American").get();
        restTemplate.getInterceptors();

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Guacamole");
        Set<Categories> categories = new HashSet<>();
        categories.add(category);
        recipe1.setCategories(categories);


        Set<Ingredient> ingredients =  new HashSet<>();

        Ingredient ing1 = new Ingredient();
        ing1.setAmount(new BigDecimal("2"));
        ing1.setDescription("ripe avocados");
        ing1.setRecipe(recipe1);
        ingredients.add(ing1);

        Ingredient ing2 = new Ingredient();
        ing2.setAmount(new BigDecimal("0.25"));
        ing2.setDescription("salt");
        ing2.setUom(teaSpoonMeasure);
        ing2.setRecipe(recipe1);
        ingredients.add(ing2);

        Ingredient ing3 = new Ingredient();
        ing3.setAmount(new BigDecimal("1"));
        ing3.setDescription("fresh lime juice");
        ing3.setUom(tableSpoonMeasure);
        ing3.setRecipe(recipe1);
        ingredients.add(ing3);

        Ingredient ing4 = new Ingredient();
        ing4.setAmount(new BigDecimal("2"));
        ing4.setDescription("Serrano Chillies");
        ing4.setRecipe(recipe1);
        ingredients.add(ing4);

        Ingredient ing5 = new Ingredient();
        ing5.setAmount(new BigDecimal("2"));
        ing5.setDescription("Serrano Chillies and seeds removed, minced");
        ing5.setRecipe(recipe1);
        ingredients.add(ing5);

        Ingredient ing6 = new Ingredient();
        ing6.setDescription("cilantro (leaves and tender stems), finely chopped");
        ing6.setAmount(new BigDecimal("1"));
        ing6.setUom(tableSpoonMeasure);
        ing6.setRecipe(recipe1);
        ingredients.add(ing6);

        Ingredient ing7 = new Ingredient();
        ing7.setDescription("A dash of freshly grated black pepper");
        ing7.setRecipe(recipe1);
        ingredients.add(ing7);

        Ingredient ing8 = new Ingredient();
        ing8.setDescription("ripe tomato, seeds and pulp removed, chopped");
        ing8.setAmount(new BigDecimal("0.5"));
        ing8.setRecipe(recipe1);
        ingredients.add(ing8);

        Ingredient ing9 = new Ingredient();
        ing9.setDescription("Red radishes or jicama, to garnish");
        ing9.setRecipe(recipe1);
        ingredients.add(ing9);

        Ingredient ing10 = new Ingredient();
        ing10.setDescription("Tortilla chips, to serve");
        ing10.setRecipe(recipe1);
        ingredients.add(ing10);

        recipe1.setIngredients(ingredients);
        recipe1.setCookTime(30);
        recipe1.setCookTime(10);
        recipe1.setLevel(Difficulty.EASY);
        recipes.save(recipe1);
        System.out.println("Break1");
        Recipe newRecipe = recipes.findByDescription("Guacamole").get();
        System.out.println("Break2");

        Ingredient ing11 = new Ingredient();
        ing11.setDescription("Tortilla chips, to abcdefgh");
        ingredients.add(ing11);


        newRecipe.getIngredients().add(ing11);

        recipes.save(newRecipe);





    }
}
