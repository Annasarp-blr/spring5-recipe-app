package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
@Slf4j
public class IndexController {
    private final CategoryRepository category;
    private final UnitOfMeasureRepository uom;

    public IndexController(CategoryRepository category, UnitOfMeasureRepository uom) {
        this.category = category;
        this.uom = uom;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        System.out.println(category.findByDescription("American"));
        System.out.println(uom.getByUom("American"));
        return "index";
    }
}