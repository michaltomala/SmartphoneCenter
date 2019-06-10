package smartphones.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import smartphones.demo.entity.Brand;
import smartphones.demo.entity.Phone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This service is created only for contact with rest api.
 * Naturally we can use our services to get brands and phones,but this is my learning - train connect to rest api
 */


@Service
public class PageRestService {

    private final String allBrandsUrl = "http://localhost:8080/api/brand/all";
    private final String allPhonesUrl = "http://localhost:8080/api/phone/all";
    private final String allFlagshipsUrl = "http://localhost:8080/api/phone/flagships";
    private final String allExFlagshipsUrl = "http://localhost:8080/api/phone/exflagships";

    private final static RestTemplate restTemplate = new RestTemplate();


    public Brand[] getAllBrands(){

        ResponseEntity<Brand[]> forEntity = restTemplate.getForEntity(allBrandsUrl,Brand[].class);
        Brand[] body = forEntity.getBody();
        if (body==null) return null;
        return body;
    }

    public List<Phone> getAllPhones(){

        ResponseEntity<Phone[]> forEntity = restTemplate.getForEntity(allPhonesUrl,Phone[].class);
        Phone[] phonesBody = forEntity.getBody();
        if (phonesBody == null) return null;
        return Arrays.stream(phonesBody).collect(Collectors.toList());
    }

    public Phone[] getAllFlagships(){

        return getAndReturnArray(allFlagshipsUrl);
    }

    public Phone[] getAllExFlagships(){

        return getAndReturnArray(allExFlagshipsUrl);
    }

    private Phone[] getAndReturnArray(String url) {
        return getAndReturnPhones(url);
    }


    public Phone[] getBrand(String name){

        String url = "http://localhost:8080/api/brand/"+name;
        return getAndReturnPhones(url);
    }


    private Phone[] getAndReturnPhones(String url) {
        ResponseEntity<Phone[]> forEntity = restTemplate.getForEntity(url, Phone[].class);
        Phone[] body = forEntity.getBody();
        if (body == null) return null;
        return body;
    }
}
