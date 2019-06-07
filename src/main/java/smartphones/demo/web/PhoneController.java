package smartphones.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import smartphones.demo.service.PageRestService;
import smartphones.demo.service.PhoneService;


@Controller
public class PhoneController {

    private final PageRestService pageRestService;


    @Autowired
    public PhoneController(PageRestService pageRestService) {
        this.pageRestService = pageRestService;
    }


    @GetMapping("/phones")
    public String getPhones(Model model){

        model.addAttribute("phones",pageRestService.getAllPhones());
        return "content/phones";
    }

    @GetMapping("/flagships")
    public String getFlagships(){

        return "content/flagships";
    }

    @GetMapping("/exflagships")
    public String getExFlagships(){

        return "content/exFlagships";
    }
}
