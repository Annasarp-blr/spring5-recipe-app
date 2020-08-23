package guru.springframework.controllers;

import guru.springframework.domain.Categories;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
@Slf4j
public class IndexController {

    private  CategoryRepository category;
    private  UnitOfMeasureRepository uom;

    public IndexController(CategoryRepository category, UnitOfMeasureRepository uom) {
        this.category = category;
        this.uom = uom;
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
        model.addAttribute("recipes", category.findByDescription("American"));
        return "index";
    }
}