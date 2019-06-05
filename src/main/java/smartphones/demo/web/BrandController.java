package smartphones.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import smartphones.demo.service.BrandService;


@Controller
public class BrandController {

    private final BrandService brandService;


    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public String getBrands(){

        return "content/brands";
    }

}
