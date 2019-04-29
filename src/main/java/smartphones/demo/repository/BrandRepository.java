package smartphones.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long> {


}
