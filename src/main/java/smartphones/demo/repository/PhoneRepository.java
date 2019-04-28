package smartphones.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
