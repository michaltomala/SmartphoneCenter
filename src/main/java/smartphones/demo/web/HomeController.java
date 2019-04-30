package smartphones.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// todo for testing
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;
import smartphones.demo.entity.PhoneDetails;
import smartphones.demo.repository.BrandRepository;
import smartphones.demo.repository.PhoneDetailsRepository;
import smartphones.demo.repository.PhoneRepository;


@Controller
public class HomeController {

    private final BrandRepository brandRepository;
    private final PhoneRepository phoneRepository;
    private final PhoneDetailsRepository phoneDetailsRepository;
    @Autowired
    public HomeController(BrandRepository brandRepository,
                          PhoneRepository phoneRepository,
                          PhoneDetailsRepository phoneDetailsRepository) {
        this.brandRepository = brandRepository;
        this.phoneRepository = phoneRepository;
        this.phoneDetailsRepository = phoneDetailsRepository;
    }


    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(){

        Brand a = new Brand();
        a.setName("OnePlus");
        brandRepository.save(a);

        Brand b = new Brand();
        b.setName("LG");
        brandRepository.save(b);

        PhoneDetails cc = new PhoneDetails();
        cc.setExFlagship(true);
        cc.setFlagship(false);
        phoneDetailsRepository.save(cc);

        Phone c = new Phone();
        c.setBrand(a);
        c.setName("6");
        c.setPrice(2000);
        c.setPhoneDetails(cc);
        phoneRepository.save(c);

        PhoneDetails dd = new PhoneDetails();
        dd.setExFlagship(false);
        dd.setFlagship(true);
        phoneDetailsRepository.save(dd);

        Phone d = new Phone();
        d.setBrand(a);
        d.setName("6T");
        d.setPrice(2200);
        d.setPhoneDetails(dd);
        phoneRepository.save(d);

        PhoneDetails ee = new PhoneDetails();
        ee.setExFlagship(true);
        ee.setFlagship(false);
        phoneDetailsRepository.save(ee);

        Phone e = new Phone();
        e.setBrand(b);
        e.setName("V30");
        e.setPrice(1300);
        e.setPhoneDetails(ee);
        phoneRepository.save(e);



        return "home";

    }


}
