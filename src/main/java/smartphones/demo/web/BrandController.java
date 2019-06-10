package smartphones.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import smartphones.demo.service.BrandService;
import smartphones.demo.service.PageRestService;


@Controller
public class BrandController {


    private final PageRestService pageRestService;


    @Autowired
    public BrandController(PageRestService pageRestService) {
        this.pageRestService = pageRestService;
    }

    @GetMapping("/brands")
    public String getBrands(Model model){

        model.addAttribute("brands",pageRestService.getAllBrands());
        return "content/brands";
    }

    @GetMapping("/singleBrand/{name}")
    public String singleBrand(@PathVariable String name,Model model){

        model.addAttribute("phones",pageRestService.getBrand(name));
        return "content/singleBrand";
    }


}
