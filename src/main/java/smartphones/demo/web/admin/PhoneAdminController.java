package smartphones.demo.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import smartphones.demo.service.PhoneService;


@Controller
@RequestMapping("/phone/")
public class PhoneAdminController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneAdminController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    /**
     * Three methods for create ,update and delete phone.
     */

//    @PostMapping("/create")
//    public void createPhone(){
//
//    }

}
