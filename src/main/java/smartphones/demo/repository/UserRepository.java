package smartphones.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
