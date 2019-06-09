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

import javax.servlet.http.HttpServletRequest;
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

// todo - first step form (create and edit) - validate ceneoUrl - must be unique
    /**
     * Three methods for create ,update and delete phone.
     */

    @GetMapping("create/firstStep/{brand}")
    public String createPhoneWithBrandSelected(@RequestParam(value = "brand") String brand, Model model,HttpServletRequest request) {

        Phone phone = new Phone();
        phone.setBrand(brandService.findBrand(brand));
        model.addAttribute("phone",phone);
        model.addAttribute("formAction", request.getContextPath() + "/admin/phone/create/firstStep");
        return "admin/phoneFormStep1";
    }

    @GetMapping("create/firstStep")
    public String createPhoneFirstStep(Model model,HttpServletRequest request) {

        model.addAttribute("phone", new Phone());
        model.addAttribute("formAction", request.getContextPath() + "/admin/phone/create/firstStep");
        return "admin/phoneFormStep1";
    }

    @PostMapping("create/firstStep")
    public String createPhoneFirstStep(Phone phone, Model model, HttpSession session){

        Err modelErr = new Err();
        phoneService.checkPhone(phone,modelErr);
        if (returnIfErrNotEmpty(phone, model, modelErr)) return "admin/phoneFormStep1";
        session.setAttribute("phone",phone);
        return "redirect:/admin/phone/create/secondStep";
    }


    @GetMapping("create/secondStep")
    public String finallyCreateStep(Model model,HttpSession session){
        if(session.getAttribute("phone")==null) return "redirect:/admin/phone/create/firstStep";
        model.addAttribute("phoneDetails",new PhoneDetails());
        return "admin/phoneFormStep2";
    }

    @PostMapping("create/secondStep")
    public String savePhone(PhoneDetails phoneDetails,Model model,HttpSession session){

        if (checkPhoneDetails(phoneDetails, model)) return "admin/phoneFormStep2";
        return savePhoneAndRedirect(phoneDetails, session);
    }

    /**
     * There are similar methods for edit phone (two forms)
     * @param id
     * @param model
     * @param request
     * @return
     */


    @GetMapping("edit/firstStep/{id}")
    public String editPhoneFirstStep(@PathVariable Long id, Model model, HttpServletRequest request){

        model.addAttribute("phone",phoneService.findPhone(id));
        model.addAttribute("formAction", request.getContextPath() + "/admin/phone/edit/firstStep/"+id);
        return "admin/phoneFormStep1";
    }

    @PostMapping("edit/firstStep/{id}")
    public String editPhoneFirstStep(Phone phone, Model model, HttpSession session){

        Err modelErr = new Err();
        phoneService.checkPhoneDuringEdit(phone,modelErr);
        if (returnIfErrNotEmpty(phone, model, modelErr)) return "admin/phoneFormStep1";
        session.setAttribute("phone",phone);
        return "redirect:/admin/phone/edit/secondStep/"+phone.getId();
    }

    private boolean returnIfErrNotEmpty(Phone phone, Model model, Err modelErr) {
        if (!modelErr.isEmpty()) {
            for (String err : modelErr.getErrors()) model.addAttribute(err, err);
            model.addAttribute("phone", phone);
            return true;
        }
        return false;
    }

    @GetMapping("edit/secondStep/{id}")
    public String finallyEditStep(@PathVariable Long id, Model model,HttpSession session){
        if(session.getAttribute("phone")==null) return "redirect:/admin/phone/edit/firstStep/"+id;
        model.addAttribute("phoneDetails",phoneService.findPhone(id).getPhoneDetails());
        return "admin/phoneFormStep2";
    }


    @PostMapping("edit/secondStep/{id}")
    public String savePhoneAfterEdit(PhoneDetails phoneDetails,Model model,HttpSession session){
        if (checkPhoneDetails(phoneDetails, model)) return "admin/phoneFormStep2";

        return savePhoneAndRedirect(phoneDetails, session);
    }

    private String savePhoneAndRedirect(PhoneDetails phoneDetails, HttpSession session) {
        phoneService.savePhone((Phone) session.getAttribute("phone"), phoneDetails);
        return "redirect:/admin/dashboard";
    }

    private boolean checkPhoneDetails(PhoneDetails phoneDetails, Model model) {
        if (phoneService.checkPhoneDetails(phoneDetails)) {
            model.addAttribute("flagshipErr", "Smartphone nie może być jednocześnie flagowcem i exflagowcem!");
            return true;
        }
        return false;
    }



    @GetMapping("/delete/{id}")
    public String deletePhone(@PathVariable Long id,Model model){

        if(id==0) return "redirect:/admin/dashboard";
        phoneService.deletePhone(id);
        return "redirect:/admin/dashboard";
    }


    @GetMapping("/delete/{id}/{brand}")
    public String deleteBrand(@PathVariable Long id,@RequestParam(value = "brand") String brandName){

        if(id==0) return "redirect:/admin/brand/single/brand?brand="+brandName;
        phoneService.deletePhone(id);
        return "redirect:/admin/brand/single/brand?brand="+brandName;
    }

    @ModelAttribute("brands")
    public List<Brand> brands(){ return brandService.getAllBrands(); }

}
