package smartphones.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.Brand;

import java.util.List;


public interface BrandRepository extends JpaRepository<Brand, Long> {

    List<Brand> findAllByOrderByNameAsc();
    Brand findFirstByName(String name);
}
