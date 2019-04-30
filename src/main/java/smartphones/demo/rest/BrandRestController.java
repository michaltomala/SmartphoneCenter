package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import smartphones.demo.entity.Brand;
import smartphones.demo.repository.BrandRepository;
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


}
