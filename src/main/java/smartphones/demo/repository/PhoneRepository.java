package smartphones.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.Phone;

import java.util.List;


public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findFirstById(Long id);
    Phone findFirstByName(String name);
    List<Phone> findAllByPhoneDetails_IsFlagship(boolean isFlagship);
    List<Phone> findAllByPhoneDetails_IsExFlagship(boolean isExFlagship);

}
