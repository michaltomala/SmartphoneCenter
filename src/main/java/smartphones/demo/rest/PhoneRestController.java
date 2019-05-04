package smartphones.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import smartphones.demo.entity.Phone;
import smartphones.demo.service.PhoneService;
import smartphones.demo.service.WebSearchService;

import java.util.List;


@RestController
@RequestMapping("/api/phone/")
public class PhoneRestController {

    private final PhoneService phoneService;
    private final WebSearchService webSearchService;

    @Autowired
    public PhoneRestController(PhoneService phoneService,WebSearchService webSearchService) {

        this.phoneService = phoneService;
        this.webSearchService = webSearchService;
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


    @RequestMapping(path = "flagships" , method = RequestMethod.GET)
    public String flagShips(){

        List<Phone> phoneList = phoneService.getAllFlagShips();
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(phoneList);
        }catch (Exception e){
            return "{'error': 'Parse problem'}" + e;
        }

    }

    @RequestMapping(path = "exflagships" , method = RequestMethod.GET)
    public String exFlagships(){

        List<Phone> phoneList = phoneService.getAllExFlagships();
        ObjectMapper mapper = new ObjectMapper();

        try{
            return mapper.writeValueAsString(phoneList);
        }catch(Exception e){
            return "{'error': 'Parse problem'}" + e;
        }
    }


    @RequestMapping(path = "{brand}/{phone}" , method = RequestMethod.GET)
    public String findPhonePrice(@PathVariable String brand , @PathVariable String phone){

        Phone phoneToReturn  = webSearchService.setAndReturnActualPhonePrice(phone);
        ObjectMapper mapper = new ObjectMapper();

        try{
            return mapper.writeValueAsString(phoneToReturn);
        }catch(Exception e){
            return "{'error': 'Parse problem'}" + e;
        }



    }


}
