package smartphones.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.PhoneDetails;



public interface PhoneDetailsRepository extends JpaRepository<PhoneDetails, Long> {

}
