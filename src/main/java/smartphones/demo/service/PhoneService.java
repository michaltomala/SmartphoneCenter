package smartphones.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Phone;
import smartphones.demo.repository.PhoneRepository;
import pl.coderslab.model.Err;

import java.util.List;


@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone findPhone(String phone){ return phoneRepository.findFirstByName(phone); }
    public List<Phone> getAllPhones(){ return phoneRepository.findAll(); }
    public List<Phone> getAllFlagShips() { return phoneRepository.findAllByPhoneDetails_IsFlagship(true); }
    public List<Phone> getAllExFlagships(){ return phoneRepository.findAllByPhoneDetails_IsExFlagship(true); }

    public void savePhone(Phone phone) { phoneRepository.save(phone); }

    public void checkPhone(Phone phone,Err modelErr){

        if(phone.getBrand() ==null) modelErr.addErr("brandErr");
        checkName(phone,modelErr);
        if(phone.getPrice()<299 || phone.getPrice()>10000) modelErr.addErr("priceErr");
        int price = WebSearchService.findPhonePrice(phone.getCeneoUrl());
        if(price <299 || price>10000) modelErr.addErr("LinkErr");

    }

    public void checkName(Phone phone,Err modelErr){

        if(phone.getName().equals("")) modelErr.addErr("phoneErr");
        Phone phoneToCheck = phoneRepository.findFirstByName(phone.getName());
        if(phoneToCheck!=null) modelErr.addErr("phoneErr");
    }


}
