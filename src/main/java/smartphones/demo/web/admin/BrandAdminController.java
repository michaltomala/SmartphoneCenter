package smartphones.demo.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import smartphones.demo.entity.Brand;
import smartphones.demo.service.BrandService;
import pl.coderslab.model.Err;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/brand/")
public class BrandAdminController {

    private final BrandService brandService;

    @Autowired
    public BrandAdminController(BrandService brandService) {
        this.brandService = brandService;
    }

    /**
     * Three methods for create ,update and delete brand.
     */

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("brand", new Brand());
        return "admin/brandForm";
    }

    @PostMapping("create")
//     todo - check if void is working
    public String createBrand(Brand brand,Model model){

        Err modelErr = new pl.coderslab.model.Err();

        brandService.checkName(brand,modelErr);
        if(!modelErr.isEmpty()){
            model.addAttribute("brandErr", "Nazwa nie może być pusta oraz musi być unikalna!");
            return "admin/brandForm";
        }

        brandService.save(brand);
        return "redirect:/admin/dashboard";
    }

//    @PostMapping("edit")
//    public String updateBrand(@Valid Brand brand, BindingResult result){

//        if(result.hasErrors()) // todo - return to form
//        brandService.save(brand);
        // todo - redirect
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteBrand(@PathVariable Long id){


        //todo ma usunąć kategorię tylko w przypadku gdy nie ma powiązanych telefonów
//        return "redirect:"+request.getContextPath()+"/brand/list";
//    }
}
