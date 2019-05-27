package smartphones.demo.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;
import smartphones.demo.service.BrandService;
import smartphones.demo.service.PhoneService;

import java.util.List;


@Controller
@RequestMapping("/admin/phone/")
public class PhoneAdminController {

    private final PhoneService phoneService;
    private final BrandService brandService;

    @Autowired
    public PhoneAdminController(PhoneService phoneService,BrandService brandService) {

        this.phoneService = phoneService;
        this.brandService = brandService;
    }


    /**
     * Three methods for create ,update and delete phone.
     */


    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("phone", new Phone());
        return "admin/phoneForm";
    }


//    @PostMapping("/create")
//    public void createPhone(){
//
//    }



    @ModelAttribute("brands")
    public List<Brand> brands(){ return brandService.getAllBrands(); }

}
