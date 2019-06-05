package smartphones.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import smartphones.demo.service.PhoneService;


@Controller
public class PhoneController {

    private final PhoneService phoneService;


    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping("/phones")
    public String getPhones(){

        return "phones";
    }

    @GetMapping("/flagships")
    public String getFlagships(){

        return "flagships";
    }

}
