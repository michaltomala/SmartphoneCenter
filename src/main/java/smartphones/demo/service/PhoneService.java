package smartphones.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Phone;
import smartphones.demo.entity.PhoneDetails;
import smartphones.demo.repository.PhoneDetailsRepository;
import smartphones.demo.repository.PhoneRepository;
import pl.coderslab.model.Err;

import java.util.List;


@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneDetailsRepository phoneDetailsRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository,PhoneDetailsRepository phoneDetailsRepository) {
        this.phoneRepository = phoneRepository;
        this.phoneDetailsRepository = phoneDetailsRepository;
    }

    public Phone findPhone(String phone){ return phoneRepository.findFirstByName(phone); }
    public Phone findPhone(Long id){ return phoneRepository.findFirstById(id); }

    public List<Phone> getAllPhones(){ return phoneRepository.findAll(); }
    public List<Phone> getAllFlagShips() { return phoneRepository.findAllByPhoneDetails_IsFlagship(true); }
    public List<Phone> getAllExFlagships(){ return phoneRepository.findAllByPhoneDetails_IsExFlagship(true); }

    public void savePhone(Phone phone) { phoneRepository.save(phone); }
    public void savePhone(Phone phone,PhoneDetails phoneDetails){
        phoneDetailsRepository.save(phoneDetails);
        phone.setPhoneDetails(phoneDetails);
        phoneRepository.save(phone);
    }


    public void checkPhone(Phone phone,Err modelErr){

        if(phone.getName().equals("")) modelErr.addErr("phoneErr");
        Phone phoneToCheck = phoneRepository.findFirstByName(phone.getName());
        if(phoneToCheck!=null) modelErr.addErr("phoneErr");
        checkBrandPriceAndCeneoLink(phone, modelErr);

    }

    public void checkPhoneDuringEdit(Phone phone,Err modelErr){

        if(phone.getName().equals("")) modelErr.addErr("phoneErr");
        Phone phoneToCheck = phoneRepository.findFirstByName(phone.getName());
        if(phoneToCheck!=null && phoneToCheck.getId() != phone.getId()) modelErr.addErr("phoneErr");
        checkBrandPriceAndCeneoLink(phone, modelErr);
    }

    private void checkBrandPriceAndCeneoLink(Phone phone, Err modelErr) {
        if(phone.getBrand() ==null) modelErr.addErr("brandErr");
        if (phone.getPrice() < 299 || phone.getPrice() > 10000) modelErr.addErr("priceErr");
        int price = WebSearchService.findPhonePrice(phone.getCeneoUrl());
        if (price < 299 || price > 10000) modelErr.addErr("LinkErr");
    }


    public boolean checkPhoneDetails(PhoneDetails phoneDetails){
        return phoneDetails.isFlagship() && phoneDetails.isExFlagship();
    }

    public void deletePhone(Long id){ phoneRepository.delete(findPhone(id)); }

}
