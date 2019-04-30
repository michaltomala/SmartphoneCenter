package smartphones.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Phone;
import smartphones.demo.repository.PhoneRepository;

import java.util.List;


@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }


    public List<Phone> getAllPhones(){ return phoneRepository.findAll(); }
    public List<Phone> getAllFlagShips() { return phoneRepository.findAllByPhoneDetails_IsFlagship(true); }
    public List<Phone> getAllExFlagships(){ return phoneRepository.findAllByPhoneDetails_IsExFlagship(true); }



}
