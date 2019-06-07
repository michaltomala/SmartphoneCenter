package smartphones.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import smartphones.demo.entity.Brand;

/**
 * This service is created only for contact with rest api.
 * Naturally we can use our services to get brands and phones,but this is my learning - train connect to rest api
 */


@Service
public class PageRestService {

    private final String allBrandsUrl = "http://localhost:8080/api/brand/all";


    public Brand[] getAllBrands(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Brand[]> forEntity = restTemplate.getForEntity(allBrandsUrl,Brand[].class);
        Brand[] body = forEntity.getBody();
        if (body==null) return null;
        return body;
    }




}
