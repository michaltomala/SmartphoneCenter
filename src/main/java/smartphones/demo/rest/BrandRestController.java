package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;
import smartphones.demo.service.BrandService;

import java.util.List;


@RestController
@RequestMapping("/api/brand/")
public class BrandRestController {

    private final BrandService brandService;

    @Autowired
    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

//todo - check if return list instead of String

    @RequestMapping(path = "all" ,method = RequestMethod.GET)
    public String allBrands(){

        List<Brand> brandList = brandService.getAllBrands();
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(brandList);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }

    @RequestMapping(path = "{name}" , method = RequestMethod.GET)
    public String singleBrand(@PathVariable String name){

        List<Phone> singleBrand = brandService.getAllPhonesFromSingleBrand(name);
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(singleBrand);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }


}
