package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import smartphones.demo.entity.Phone;
import smartphones.demo.service.PhoneService;

import java.util.List;


@RestController
@RequestMapping("/api/phone/")
public class PhoneRestController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneRestController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @RequestMapping(path = "all" ,method = RequestMethod.GET)
    public String allPhones(){

        List<Phone> phoneList = phoneService.getAllPhones();

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(phoneList);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }

    }


}
