package smartphones.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;
import smartphones.demo.repository.BrandRepository;

import java.util.List;


@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand findBrand(Long id){ return brandRepository.getOne(id); }
    public Brand findBrand(String brand){ return brandRepository.findFirstByName(brand); }

    public List<Brand> getAllBrands(){ return brandRepository.findAllByOrderByNameAsc();   }

    public List<Phone> getAllPhonesFromSingleBrand(String brand){
        Brand singleBrand = findBrand(brand);
        return singleBrand.getPhones();
    }


}

