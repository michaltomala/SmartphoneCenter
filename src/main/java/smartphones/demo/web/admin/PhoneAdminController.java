package smartphones.demo.web.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;
import smartphones.demo.entity.PhoneDetails;
import smartphones.demo.service.BrandService;
import smartphones.demo.service.PhoneService;
import pl.coderslab.model.Err;

import javax.servlet.http.HttpSession;
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


    @GetMapping("create/firstStep")
    public String createPhoneFirstStep(Model model) {

        model.addAttribute("phone", new Phone());
        return "admin/phoneFormStep1";
    }


    @PostMapping("create/firstStep")
    public String createPhoneFirstStep(Phone phone, Model model, HttpSession session){

        Err modelErr = new Err();
        phoneService.checkPhone(phone,modelErr);

        if(!modelErr.isEmpty()) {
            for(String err : modelErr.getErrors())model.addAttribute(err,err);
            model.addAttribute("phone",phone);
            return "admin/phoneFormStep1";
        }

        session.setAttribute("phone",phone);
        return "redirect:/admin/phone/create/secondStep";
    }

    @GetMapping("create/secondStep")
    public String finallyCreateStep(Model model,HttpSession session){
// todo validate if phone from session is empty
        if(session.getAttribute("phone")==null) return "redirect:/admin/phone/create/firstStep";
        model.addAttribute("phoneDetails",new PhoneDetails());
        return "admin/phoneFormStep2";
    }

    @PostMapping("create/secondStep")
    @ResponseBody
    public String savePhone(PhoneDetails phoneDetails){
// todo - validate if isFlagship is true and isExFlagship is true
        return "dupa";
    }

    @ModelAttribute("brands")
    public List<Brand> brands(){ return brandService.getAllBrands(); }

}
