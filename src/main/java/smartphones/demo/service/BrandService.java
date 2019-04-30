package smartphones.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphones.demo.entity.Brand;
import smartphones.demo.repository.BrandRepository;

import java.util.List;


@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<Brand> getAllBrands(){ return brandRepository.findAllByOrderByNameAsc();   }


}
